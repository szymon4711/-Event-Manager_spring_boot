package com.eventmanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "\"like\"")
    private Integer like;

    @Column(name = "dislike")
    private Integer dislike;

    @Column(name = "uncertain")
    private Integer uncertain;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "image")
    private String image;

    @Column(name = "location", length = 100)
    private String location;

}