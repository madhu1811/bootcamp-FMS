package com.capg.fms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.context.annotation.Role;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capg.fms.dao.FlightDao;
import com.capg.fms.dto.Flight;
import com.capg.fms.service.FlightService;

import mockit.integration.junit4.JMockit;



@SuppressWarnings("unused")
@RunWith(JMockit.class)
public class FlightServiceTests {
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
    private FlightDao flightRepo;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void viewAll(){
		List<Flight> flightList = new ArrayList<Flight>();
		flightList.add(new Flight(1283,"SPICEJET","AU189",200));
		when(flightRepo.findAll()).thenReturn(flightList);
		List<Flight> result = (List<Flight>) flightRepo.findAll();
		assertEquals(1, flightList.size());
	}
	@Test
	public void addFlight() {
		Flight flight=new Flight(1284,"AIR ASIA","AU185",250);
		flight.setFlightNumber(1284);
		flight.setFlightModel("AIR ASIA");
		flight.setCarrierName("AU135");
		flight.setSeatCapacity(250);
		flightRepo.save(flight);
	}
	@Test
	public void modifyFlight() {
		Flight flight=new Flight(1284,"AIR ASIA","AU185",150);
		flightRepo.findById((long) 1284);
		flightRepo.save(flight);
	   verify(flightRepo, Mockito.times(1)).save(flight);
	}
	
	
	
	@Test
        public void deleteFlight(){
		Flight flight=new Flight(1284,"AIR ASIA","AU185",150);
	
        flightRepo.deleteById((long) 1284);
	    verify(flightRepo, Mockito.times(1)).deleteById((long) 1284);
	}

}
