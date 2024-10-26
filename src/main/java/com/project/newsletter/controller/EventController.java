package com.project.newsletter.controller;

import com.project.newsletter.exception.DuplicateEventException;
import com.project.newsletter.model.Event;
import com.project.newsletter.service.EventService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllEvents() {
        log.info("getAllEvents >>");
        List<Event> eventList = eventService.getAllEvents();
        return ResponseEntity.status(HttpStatus.OK).body(eventList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@Valid @RequestBody Event event) {
        log.info("addEvent >>");

        Optional<Event> existingEvent = eventService.getEventByName(event.getName());

        if (existingEvent.isPresent()) {
            throw new DuplicateEventException("Event already exists");
        }

        Event savedEvent = eventService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }
}
