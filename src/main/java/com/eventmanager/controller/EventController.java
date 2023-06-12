package com.eventmanager.controller;

import com.eventmanager.dto.EventDto;
import com.eventmanager.dto.request.EventRequest;
import com.eventmanager.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;
    @GetMapping
    public ResponseEntity<List<EventDto>> getAll() {
        List<EventDto> events = eventService.findAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<List<EventDto>> getAllUserEvents() {
        List<EventDto> events = eventService.findAllUserEvents();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<EventDto>> search(@RequestParam("search") String searchQuery) {
        List<EventDto> events = eventService.getEventByTitleOrDescription(searchQuery);
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody EventRequest eventRequest) {
        eventService.save(eventRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
