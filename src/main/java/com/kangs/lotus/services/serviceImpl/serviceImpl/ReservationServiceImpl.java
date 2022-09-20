package com.kangs.lotus.services.serviceImpl.serviceImpl;

import com.kangs.lotus.Repository.ReservationRepository;
import com.kangs.lotus.model.Reservation;
import com.kangs.lotus.model.User;
import com.kangs.lotus.services.serviceImpl.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservation() throws Exception {
        if(reservationRepository.findAll() != null){
            return reservationRepository.findAll();
        }else {
            throw new Exception("there is no Reservation");
        }
    }

    @Override
    public String saveReservation(Reservation reservation) {
        if(reservation != null){
            reservationRepository.save(reservation);
            return "Successfully Saved";
        }else{
            return "it's a Bad Request, try again...";
        }
    }

    @Override
    public String cancelPendingReservation() {

        //get All reservation
        List<Reservation> reservationList = reservationRepository.findAll();

        //filter pending reservation and remove unpaid reservation
        for (Reservation reservation : reservationList) {
            if(reservation.getIsPayed().equals(false)){
                reservationRepository.delete(reservation);
            }else{
                System.out.println("skip");
            }
        }
        return null;
    }
}
