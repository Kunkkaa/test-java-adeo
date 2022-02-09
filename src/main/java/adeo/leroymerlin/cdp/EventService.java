package adeo.leroymerlin.cdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

	private final EventRepository eventRepository;

	@Autowired
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public List<Event> getEvents() {
		return eventRepository.findAllBy();
	}

	public void delete(Long id) {
		eventRepository.deleteById(id);
	}

	public void updateEvent(Event event, Long id) {
			eventRepository.save(event);
	}

	public List<Event> getFilteredEvents(String query) {
		List<Event> events = eventRepository.findAllBy();
		return events.stream().filter(event -> event.getTitle().startsWith(query)).collect(Collectors.toList());
	}
}
