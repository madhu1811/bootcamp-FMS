package com.capg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.dao.FlightDao;
import com.capg.fms.dao.LoginDao;
import com.capg.fms.dto.Flight;
import com.capg.fms.dto.Login;
import com.capg.fms.exception.FlightException;



@Service
public class FlightServiceImpl implements FlightService {


	@Autowired(required = true)
    FlightDao flightRepo;
	@Autowired
	LoginDao loginRepo;
	

	 @Override
	 @Transactional
	  public Flight addFlight (Flight flight)throws FlightException {
		  System.out.println(flight);
		  if(flightRepo.existsById(flight.getFlightNumber())) {
			 throw new FlightException("Flight Already Exits");
		  }
		 return flightRepo.save(flight);
	  }	
	  

	 @Override
		@Transactional
		public Flight deleteFlight(long flightNumber) throws FlightException{
		 Flight flight=null;
		 if(flightRepo.existsById(flightNumber))
		 {
		 flight=flightRepo.findById(flightNumber).get();
		 flightRepo.deleteById(flightNumber);
		 }
			return flight;
	 }
	 
	 @Override
	 @Transactional
		public Flight modifyFlight(Flight newFlightData) throws FlightException {

		 Flight flight =null;
		 long fnum = newFlightData.getFlightNumber();
			if( flightRepo.existsById(fnum))
			{
				 flight = flightRepo.findById(fnum).get();
				 System.out.println(flight);
			}
			else
			{
				throw new FlightException("Id not found");
			}

			 return flightRepo.save(newFlightData);

	}

	 @Override
		public List<Flight> viewAll(){	
			return (List<Flight>) flightRepo.findAll();
		}





	@Override
	public Flight viewFlight(long flightNumber) throws FlightException {
		 Flight flight=null;
		    if(flightRepo.existsById(flightNumber))
		    {
		    	flight=flightRepo.findById(flightNumber).get();
		    }
		    else {
		    	throw new FlightException("FLIGHT NUMBER" +" "+flightNumber+" " +"NOT FOUND");
		    }
		    return flight;
		
	}


	@Override
	public Login findUser(String username, String password) throws FlightException {
		return loginRepo.findUser(username,password);
	}
		

	
	
}
