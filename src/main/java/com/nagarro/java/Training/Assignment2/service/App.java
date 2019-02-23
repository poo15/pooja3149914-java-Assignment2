/*
* 
* @author pooja01 
* @version 0.0.1-SNAPSHOT
*/
package com.nagarro.java.Training.Assignment2.service;

import java.util.List;

import com.nagarro.java.Training.Assignment2.dto.Flight;
import com.nagarro.java.Training.Assignment2.io.Output;
import com.nagarro.java.Training.Assignment2.service.interfaces.FlightServiceImplementaion;

public class App
{
	/**
     * Main method calls the Flight search interface methods to get selected flights
     * 
     * @param args
     */
    public static void main( String[] args ) {
    	
    	FlightServiceImplementaion f = new FlightServiceImplementaion();
    	List<Flight> flights = f.getSelectedFlight();
    	Output output = new Output();
    	output.showAvailableFlightDetails(flights);
    }
    
    
    
}
