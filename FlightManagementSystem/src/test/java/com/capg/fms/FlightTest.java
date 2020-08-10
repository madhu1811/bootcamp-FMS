package com.capg.fms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.capg.fms.dto.Flight;

import mockit.integration.junit4.JMockit;
@RunWith(JMockit.class)
public class FlightTest {
	@Before
	public void initInput()
	{
		
	}
	@Test()
	public void testFlight()
	{
		Flight flight=new Flight(102,"SpiceJet","A1112",150);
		assertNotEquals(101,flight.getFlightNumber());
		assertNotEquals("AirIndia",flight.getCarrierName());
		assertNotEquals("A1111",flight.getFlightModel());
		assertNotEquals(200,flight.getSeatCapacity());
	}
	@Test
	  public final void testToString() {
		  Flight f1= new Flight(101,"SpiceJet","A45RT",200);
		  String result = String.format("Flight [flightNumber=%s,carrierName=%7s,flightModel=%5s,seatCapacity=%3s]",
				  f1.getFlightNumber(),f1.getCarrierName(), f1.getFlightModel(), f1.getSeatCapacity());
		  System.out.println(result);
		  System.out.println(f1.toString());
		  assertNotEquals(result, f1.toString());
	  }
}
