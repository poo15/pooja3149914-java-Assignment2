/*
* 
* @author pooja01 
* @version 0.0.1-SNAPSHOT
*/
package com.nagarro.java.Training.Assignment2.service.interfaces;

import java.util.List;

import com.nagarro.java.Training.Assignment2.dto.Flight;

public interface FlightService {
	
	void getAllFlights();
	
	List<Flight> getSelectedFlight();
	
}
