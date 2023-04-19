package com.eventmanager.service;

import com.eventmanager.dto.EventDto;
import com.eventmanager.model.Event;

import java.util.List;

public interface EventService {
    List<EventDto> findAll();
    List<EventDto> getEventByTitleOrDescription(String searchQuery);
}
