package com.nagarro.java.Training.Assignment2.io;

import java.util.List;

import com.nagarro.java.Training.Assignment2.constants.Constants;
import com.nagarro.java.Training.Assignment2.dto.Flight;


public class Output {
	
	/**
	 * This method print all the available flights from the list
	 * @param flights, it contains the list of flights
	 */
	
	public void showAvailableFlightDetails(List<Flight> flights) {
		if(flights.isEmpty()) {
			System.out.println(Constants.NO_RESULT_FOUNT);
		} else {
				System.out.println(Constants.PRINT_FLIGHT_DETAILS);
				flights.forEach(flight -> System.out.println(flight));
		}
	}
	
}
