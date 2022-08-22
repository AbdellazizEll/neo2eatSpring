package com.jwtproject.userSecurity.Service;


import com.jwtproject.userSecurity.Entity.Reservation;
import com.jwtproject.userSecurity.Entity.Reservation;
import com.jwtproject.userSecurity.Entity.User;
import com.jwtproject.userSecurity.Response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ReservationSer  {


    Page<Reservation> findAll(Pageable pageable);

    Page<Reservation> findReservationByStatus(Integer status, Pageable pageable);

    Page<Reservation> findReservationByCustomerUsername(String email, Pageable pageable);

    Page<Reservation> findReservationByCustomerPhone(String phone, Pageable pageable);


    Reservation  findOne(Long reservationId);

    Reservation finish(Long reservationId);

    Reservation cancel(Long ReservationId);

    public MessageResponse save(Reservation Reservation);
    public MessageResponse update(Reservation Reservation);

    @Transactional
    void deleteReservation(Long id);




}
