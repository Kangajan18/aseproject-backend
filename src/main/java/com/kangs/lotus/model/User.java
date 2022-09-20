package com.kangs.lotus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String nic;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String travelCompanyName;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservationList;

    @OneToMany(mappedBy = "user")
    private List<Card> cardList;


}
