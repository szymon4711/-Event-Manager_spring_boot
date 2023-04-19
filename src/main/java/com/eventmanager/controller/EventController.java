package com.eventmanager.controller;

import com.eventmanager.dto.EventDto;
import com.eventmanager.model.Event;
import com.eventmanager.repository.EventRepository;
import com.eventmanager.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;
    @GetMapping
    public ResponseEntity<List<EventDto>> getAll() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<EventDto>> search(@RequestParam("search") String searchQuery) {
        List<EventDto> events = eventService.getEventByTitleOrDescription(searchQuery);
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(events, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity add() {
        return null; // TODO
    }

    @DeleteMapping
    public ResponseEntity delete() {
        return null; // TODO
    }

}
