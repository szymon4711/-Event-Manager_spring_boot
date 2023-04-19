package com.eventmanager.service;

import com.eventmanager.dto.EventDto;
import com.eventmanager.dto.mapper.EventMapper;
import com.eventmanager.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getEventByTitleOrDescription(String searchQuery) {
        return eventRepository.findByTitleOrDescription(searchQuery).stream().map(eventMapper::toDto).collect(Collectors.toList());

    }
}
