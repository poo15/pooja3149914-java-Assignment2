package com.nagarro.java.Training.Assignment2.dao;

import java.text.ParseException;
import java.util.List;

import com.nagarro.java.Training.Assignment2.dto.Flight;
import com.nagarro.java.Training.Assignment2.dto.FlightSearchParameter;

public interface FlightDao {

	
	 void getAllFlight();
	
	 List<Flight> returnSelectedFlights(FlightSearchParameter flightSearchParameter) throws ParseException;
	
}
