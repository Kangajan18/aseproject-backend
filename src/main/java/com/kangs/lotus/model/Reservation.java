package com.kangs.lotus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String check_in;
    private String check_out;
    private Double totalAmount;
    private String paymentType;
    private Boolean isPayed;
    private String date;
    private ArrayList<String> services;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    private User user;

    @OneToMany
    @JoinColumn(name = "room_id",referencedColumnName = "id")
    private List<Room> roomList;
}
