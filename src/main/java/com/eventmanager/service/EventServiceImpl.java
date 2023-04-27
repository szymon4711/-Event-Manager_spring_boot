package com.eventmanager.service;

import com.eventmanager.dto.EventDto;
import com.eventmanager.dto.mapper.EventMapper;
import com.eventmanager.dto.request.EventRequest;
import com.eventmanager.model.Event;
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
    private final EventMapper.EventRequestMapper eventRequestMapper;

    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getEventByTitleOrDescription(String searchQuery) {
        return eventRepository.findByTitleOrDescription(searchQuery).stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(EventRequest eventRequest) {
        Event event = eventRequestMapper.toEntity(eventRequest);
        event.setIdAssignedBy(6); // TODO

        event.setLike(0);
        event.setDislike(0);
        event.setUncertain(0);
        eventRepository.save(event);
    }

    @Override
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }
}
