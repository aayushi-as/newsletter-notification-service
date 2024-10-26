package com.project.newsletter.service;

import com.project.newsletter.model.Event;
import com.project.newsletter.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        log.info("getAllEvents >>");
        return eventRepository.findAll();
    }

    public Event addEvent(Event event) {
        if (event != null) {
            log.info("addEvent >> {}", event);
            return eventRepository.save(event);
        }
        else {
            log.error("addEvent >> null event");
            return null;
        }
    }

    public Optional<Event> getEventByName(String name) {
        return eventRepository.findByName(name);
    }

}
