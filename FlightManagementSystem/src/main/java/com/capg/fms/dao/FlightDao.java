package com.capg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.dto.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Long>{
}


