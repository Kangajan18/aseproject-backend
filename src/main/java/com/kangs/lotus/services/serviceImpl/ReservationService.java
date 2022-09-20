package com.kangs.lotus.services.serviceImpl;

import com.kangs.lotus.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    List<Reservation> getAllReservation() throws Exception;

    String saveReservation(Reservation reservation);

    String cancelPendingReservation();
}
