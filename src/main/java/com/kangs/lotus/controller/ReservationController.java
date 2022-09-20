package com.kangs.lotus.controller;

import com.kangs.lotus.model.Reservation;
import com.kangs.lotus.services.serviceImpl.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reservation/")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAllReservation/")
    public List<Reservation> getAllReservatoin() throws Exception {
        return reservationService.getAllReservation();
    }


    @PostMapping("/saveReservation")
    public String saveReservation(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }

    //reservation 7pm caller
    public String cancelPendingReservation(){
        return reservationService.cancelPendingReservation();
    }
}
