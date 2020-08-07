package com.capg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.dto.Flight;
import com.capg.fms.dto.Login;
import com.capg.fms.exception.FlightException;
import com.capg.fms.service.FlightServiceImpl;


@CrossOrigin("*")

@RestController
@RequestMapping("/flights")
public class FlightController {
	/* http://localhost:9085/flights/flight/add
	* POSTMAN (Post : body{ "flightModel" : "SpiceJet", "carrierName" : "air", "seatCapacity" : 50 })
	* Don't insert number, number is :@GeneratedValue(strategy =GenerationType.SEQUENCE)
	*/

	@Autowired
	FlightServiceImpl flightservice;  
	@GetMapping("admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) throws FlightException
	{
	  
		 Login log = flightservice.findUser(username,password);
		 if(log==null) {
			 throw new FlightException("Login not successfull");
		 }
		 return new ResponseEntity<>(log,HttpStatus.OK);
		
		
	}
	@PostMapping("/add")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight)throws FlightException{
		flightservice.addFlight(flight);
		return new ResponseEntity<>(flight,HttpStatus.CREATED);
	}


	/* 
	 * This deleteFlightById(long flightNumber) method will removes a particular flight
	 */
	@DeleteMapping("/delete/{flightNumber}")
	public ResponseEntity<Flight> deleteFlight(@PathVariable long flightNumber)throws FlightException{
		Flight deleted = flightservice.deleteFlight(flightNumber);
	if(deleted.getFlightNumber()==flightNumber)
		return new ResponseEntity<>(deleted,HttpStatus.OK);
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	
	/*
	 * This all() method will view the details of all flights
	 */
	@GetMapping("/viewAll")
	public ResponseEntity<List<Flight>> getAllFlights(){
	List<Flight> allFlights=flightservice.viewAll();	
	return new ResponseEntity<List<Flight>>(allFlights,HttpStatus.OK);
	}
	
	/*
	 * This modify() method will update the details of all flights
	 */
	
	@PutMapping("/modify")
	public ResponseEntity<Flight> modifyFlight(@RequestBody Flight flight)throws FlightException{
		Flight newFlight=flightservice.modifyFlight(flight);
		return new ResponseEntity<>(newFlight,HttpStatus.OK);
	}
	
	/*
	 * This find() method will view the details of a flight
	 */
	@GetMapping("/view/{flightNumber}")
    public ResponseEntity<Flight> viewFlight(@PathVariable long flightNumber)throws FlightException{
    	Flight flight = flightservice.viewFlight(flightNumber);
    	if(flight.getFlightNumber()==flightNumber)
    		return new ResponseEntity<>(flight,HttpStatus.OK);
    	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}





