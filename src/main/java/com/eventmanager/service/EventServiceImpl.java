package com.eventmanager.service;

import com.eventmanager.dto.EventDto;
import com.eventmanager.dto.mapper.EventMapper;
import com.eventmanager.dto.request.EventRequest;
import com.eventmanager.model.Event;
import com.eventmanager.repository.EventRepository;
import com.eventmanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final EventMapper eventMapper;
    private final EventMapper.EventRequestMapper eventRequestMapper;

    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> findAllUserEvents() {
        var authEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByEmail(authEmail);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return eventRepository.findByIdAssignedBy(user.get().getId()).stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getEventByTitleOrDescription(String searchQuery) {
        return eventRepository.findByTitleOrDescription(searchQuery).stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(EventRequest eventRequest) {
        Event event = eventRequestMapper.toEntity(eventRequest);
        var authEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByEmail(authEmail);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        event.setLike(0);
        event.setDislike(0);
        event.setUncertain(0);
        event.setIdAssignedBy(user.get().getId());
        eventRepository.save(event);
    }

    @Override
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }
}
