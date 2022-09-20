package com.kangs.lotus.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    private String roomType;
    private boolean isAvailable;
}
