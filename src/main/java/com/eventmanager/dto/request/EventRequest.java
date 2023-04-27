package com.eventmanager.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.eventmanager.model.Event} entity
 */
public record EventRequest(String title,
                           String description,
                           LocalDate date,
                           String image,
                           String location) implements Serializable {
}