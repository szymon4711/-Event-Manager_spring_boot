package com.eventmanager.dto.mapper;

import com.eventmanager.dto.EventDto;
import com.eventmanager.dto.request.EventRequest;
import com.eventmanager.model.Event;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    Event toEntity(EventDto eventDto);

    EventDto toDto(Event event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event partialUpdate(EventDto eventDto, @MappingTarget Event event);

    @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
    interface EventRequestMapper {
        Event toEntity(EventRequest eventRequest);

        EventRequest toDto(Event event);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        Event partialUpdate(EventRequest eventRequest, @MappingTarget Event event);
    }
}