package com.eventmanager.repository;

import com.eventmanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("FROM Event WHERE title ILIKE %:search% OR description ILIKE %:search%")
    List<Event> findByTitleOrDescription(@Param("search") String search);
    List<Event> findByIdAssignedBy(Integer idAssignedBy);
}

