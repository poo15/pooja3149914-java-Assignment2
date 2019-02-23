/*
* 
* @author pooja01 
* @version 0.0.1-SNAPSHOT
*/
package com.nagarro.java.Training.Assignment2.service.interfaces;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.nagarro.java.Training.Assignment2.dao.FlightDaoImplementation;
import com.nagarro.java.Training.Assignment2.dto.Flight;
import com.nagarro.java.Training.Assignment2.dto.FlightSearchParameter;
import com.nagarro.java.Training.Assignment2.io.Input;

public class FlightServiceImplementaion implements FlightService{

	private FlightDaoImplementation flightDao = new FlightDaoImplementation();
	List<Flight> selectedFlightList = new ArrayList<Flight>();
	FlightSearchParameter flightSearchParamter ;
	Thread thread1;
	
	final CountDownLatch latch = new CountDownLatch(1);
	/**
	 * This method call the getAllFlights function and get all the flights details from the csv files
	 * It creates a thread that continuously run in background update the records
	 */
	@Override
	public void getAllFlights() {
		thread1 = new Thread(()->{
			while(true){
			flightDao.getAllFlight();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(latch.getCount()==0){
				return;
			}
			
			}
		});
		thread1.start();
	}

	/**
	 * This function calls the getSearchDeatils function and return the result after perform search operation
	 * 
	 * @return selectedFlightList,  The list that contain all the searched flights
	 */
	@Override
	public List<Flight> getSelectedFlight() {
		getAllFlights();
		Input input = new Input();
		flightSearchParamter = input.getSearchDetails();
		selectedFlightList = returnSelectedflight(flightSearchParamter);
		latch.countDown();
	    return selectedFlightList;
	}
	
	/**
	 * This function calls the returnSelectedFlights function from the DAO layer
	 * 
	 * @return selectedFlightList,  The list that contain all the searched flights
	 */
	private List<Flight> returnSelectedflight(FlightSearchParameter flightSearchParameter){
		
		List<Flight> searchedResultFlights = new ArrayList<Flight>();
		if(flightSearchParameter != null){
			try {
				searchedResultFlights = flightDao.returnSelectedFlights(flightSearchParameter);
			} catch (ParseException parseException) {
				System.out.println(parseException.getMessage());
			}
		}
		return searchedResultFlights;
		
	}
	
}
