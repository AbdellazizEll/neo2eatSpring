package com.jwtproject.userSecurity.Repository;

import com.jwtproject.userSecurity.Entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ReservationRepository  extends JpaRepository<Reservation,Long> {

    Reservation  findByReservationId(Long reservationId);



    @Override
    boolean existsById(Long reservationid);

    Page<Reservation> findAllByReservationStatus(Integer reservationStatus, Pageable pageable);

    Page<Reservation>findByCustomerId(Long customerId, Pageable pageable);

    Page<Reservation> findReservationByByCustomerUsername(String buyerUsername, Pageable pageable);




}
