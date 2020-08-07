package com.capg.fms.service;

import java.util.List;

import com.capg.fms.dto.Flight;
import com.capg.fms.dto.Login;
import com.capg.fms.exception.FlightException;



public interface FlightService {
	
	public Login findUser(String username , String password) throws FlightException;
	
	public Flight addFlight(Flight flight)throws FlightException;
	
	public Flight modifyFlight(Flight flight)throws FlightException;
	
	public Flight viewFlight(long flightNumber) throws FlightException;
	
	public Flight deleteFlight(long flightNumber) throws FlightException;
		
	public List<Flight> viewAll();
}
