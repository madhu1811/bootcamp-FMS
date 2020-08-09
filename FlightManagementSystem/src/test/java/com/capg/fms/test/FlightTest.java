package com.capg.fms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;
import com.capg.fms.dto.Flight;

@RunWith(JMockit.class)

public class FlightTest {
/*
 * setup method
 */
	@Before
	public void initInput()
	{
		
	}
	Long flightNumber=Long.valueOf(1L);
	 @Test()
	  public final void testEquals() throws NullPointerException {
		  Flight f1=new Flight();
		  assertNotNull(f1);
		  Flight f2=null;
		  Flight f3= new Flight(flightNumber,"SpiceJet","AUI89",200);
		  Flight f4= new Flight(flightNumber,"SpiceJet","AUI89",200);
		  assertTrue(f3.equals(f4));
		  assertFalse(f3.equals(f2));
	 }
	@Test()
	public void testFlight()
	{
		Flight flight=new Flight(flightNumber,"AirIndia","A1111",200);
		//assertEquals(flightNumber,flight.getFlightNumber());
		assertEquals("AirIndia",flight.getCarrierName());
		assertEquals("A1111",flight.getFlightModel());
		assertEquals(200,flight.getSeatCapacity());
	}
	@Test
	  public final void testToString() {
		  Flight f1= new Flight(flightNumber,"SpiceJet","A45RT",200);
		  String result = String.format("Flight [flightNo=%s,carrierName=%7s,flightModel=%5s,seatCapacity=%3s]",
				  f1.getFlightNumber(),f1.getCarrierName(), f1.getFlightModel(), f1.getSeatCapacity());
		  System.out.println(result);
		  System.out.println(f1.toString());
		  assertEquals(result, f1.toString());
	  }
}
