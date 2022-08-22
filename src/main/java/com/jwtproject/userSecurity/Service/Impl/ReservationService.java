package com.jwtproject.userSecurity.Service.Impl;


import com.jwtproject.userSecurity.Entity.Reservation;
import com.jwtproject.userSecurity.Repository.ReservationRepository;
import com.jwtproject.userSecurity.Response.MessageResponse;
import com.jwtproject.userSecurity.Service.ReservationSer;
import com.jwtproject.userSecurity.enums.CommandStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class ReservationService implements ReservationSer {


    @Autowired
    ReservationRepository reservationRepository;


    @Override
    public MessageResponse save(Reservation reservationInfo) {
        return update(reservationInfo);
    }

    public MessageResponse update(Reservation reservationInfo)
    {
        boolean existe = reservationRepository.existsById(reservationInfo.getId());
        reservationRepository.save(reservationInfo);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservationInfo = findOne(id);
        if (reservationInfo == null) throw new ReservationNotFoundException("Reservation not found");
        reservationRepository.delete(reservationInfo);

    }

    public Page<Reservation> findAll(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Page<Reservation> findReservationByStatus(Integer status, Pageable pageable) {
        return reservationRepository.findAllByReservationStatus(status, pageable);
    }

    @Override
    public Page<Reservation> findReservationByCustomerUsername(String username, Pageable pageable) {
        return reservationRepository.findReservationByByCustomerUsername(username, pageable);
    }


    @Override
    public Reservation findOne(Long reservationId) {
        Reservation reservation = reservationRepository.findByReservationId(reservationId);
        if(reservation == null) {
            throw new RestaurantNotFoundException("Reservation not found ");
        }
        return reservation;
    }


  /*  public Reservation finish(Long ReservationId) {
        Reservation reservationMain = findOne(ReservationId);
        if(!reservationMain.getR.equals(ReservationStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.Reservation_STATUS_ERROR);
        }

        reservation.setReservationStatus(ReservationStatusEnum.FINISHED.getCode());
        reservationRepository.save(reservation);
        return reservationRepository.findByReservationId(ReservationId);
    }


   */

    @Override
    @Transactional
    public Reservation cancel(Long ReservationId) {
        Reservation reservation = findOne(ReservationId);
        if(!reservation.getReservationStatus().equals(CommandStatusEnum.NEW.getCode())) {
            throw new ReservationNotFoundException("Reservation not found ");
        }

        reservation.setReservationStatus(CommandStatusEnum.CANCELED.getCode());
        reservationRepository.save(reservation);


        return reservationRepository.findByReservationId(ReservationId);

    }

}
 class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String message) {
        super(message);
    }
}