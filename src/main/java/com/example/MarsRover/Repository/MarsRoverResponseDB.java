package com.example.MarsRover.Repository;

import com.example.MarsRover.Model.MarsRoverResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MarsRoverResponseDB extends JpaRepository<MarsRoverResponse, LocalDate> {
    MarsRoverResponse findByDate(LocalDate date);
}
