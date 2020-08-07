package com.capg.fms;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.fms.dao.FlightDao;
import com.capg.fms.dto.Flight;
import com.capg.fms.exception.FlightException;
import com.capg.fms.service.FlightService;



@SpringBootTest
class FlightManagementSystemApplicationTests {

	@Autowired
	private FlightService flightservice;
	
	@MockBean
	private FlightDao flightrepo;
	
	@Test
	public void getFlightTest() throws FlightException{
		when(flightrepo.findAll()).thenReturn(Stream.of(new Flight(90,"cargo","indigo",99)).collect(Collectors.toList()));
		assertEquals(1,flightservice.viewAll().size());
	}

	

}
