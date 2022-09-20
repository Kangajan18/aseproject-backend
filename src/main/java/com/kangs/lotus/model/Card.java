package com.kangs.lotus.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private String expireDate;
    private String secretNumber;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
