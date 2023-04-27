package com.eventmanager.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.eventmanager.model.Event} entity
 */
public record EventDto(
        Integer id,
        String title,
        String description,
        Integer like,
        Integer dislike,
        Integer uncertain,
        LocalDate date,
        String image,
        String location) implements Serializable {
}