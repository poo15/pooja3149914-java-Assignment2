/*
* 
* @author pooja01 
* @version 0.0.1-SNAPSHOT
*/
package com.nagarro.java.Training.Assignment2.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.nagarro.java.Training.Assignment2.constants.Constants;
import com.nagarro.java.Training.Assignment2.dto.Flight;
import com.nagarro.java.Training.Assignment2.dto.FlightSearchParameter;

public class FlightDaoImplementation implements FlightDao {

	List<Flight> flightList = new ArrayList<Flight>();
	List<Flight> searchedFlightList = new ArrayList<Flight>();
	
	SimpleDateFormat standardDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
	
	/**
	 * This method get all the flights details from the csv files
	 * 
	 */
	@Override
	public void getAllFlight() {
			flightList.clear();
			File[] files = new File(Constants.DIRECTORY_LOCATION).listFiles();
			for(File file: files){
				getRecordsOfFlight(Constants.DIRECTORY_LOCATION+file.getName());
			}
			//System.out.println(files.length);
	}
	
	/**
	 * This method add the records of a file into the list of Flight
	 * 
	 * @param fileLocation,  the string that contains the path of the file
	 */
	private void getRecordsOfFlight(String fileLocation){
		String line = null;
		try{
		BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
		line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			String[] flightRecord = line.split(Constants.SPLIT_BY);
			Flight flight = new Flight(flightRecord[Constants.FLIGHT_NO],flightRecord[Constants.DEP_LOC],
					flightRecord[Constants.ARR_LOC],standardDateFormat.parse(flightRecord[Constants.VALID_TILL]),
					flightRecord[Constants.FLIGHT_TIME],flightRecord[Constants.FLIGHT_DUR],
					Double.parseDouble(flightRecord[Constants.FARE]),flightRecord[Constants.SEAT_AVAILABILITY],
					flightRecord[Constants.CLASS]);
			flightList.add(flight);
		}
		reader.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * This method matches the flight from the list of flights and call the function to sort the result
	 * 
	 * @param flightSearchParameter, it contains the parameters to search the flight
	 * 
	 * @return searchedFlightList, it return the list of searched flights
	 */
	@Override
	public List<Flight> returnSelectedFlights(FlightSearchParameter flightSearchParameter) throws ParseException {
		Date searchDate = standardDateFormat.parse(flightSearchParameter.getFlightDate());
		String searchClass = flightSearchParameter.getFlightclass().toUpperCase();
		flightList.forEach(flight -> {
			String flightClass=flight.getFlightclass();	
			if(flight.getDepartureLocation().equalsIgnoreCase(flightSearchParameter.getDepartureLocation())
					&& flight.getArrivalLocation().equalsIgnoreCase(flightSearchParameter.getArrivalLocation())
					&& flightClass.contains(searchClass) && (searchDate.compareTo(flight.getValidTillDate()) == 0 )
					&& flight.getSeatAvailability().equals(Constants.AVAILABILITY)){
					if(searchClass.contains(Constants.BUSSINESS))
						flight.setFare(flight.getFare() + flight.getFare()*0.40);
					searchedFlightList.add(flight);
			}
		});
		resultOutputPreferences(flightSearchParameter.getOutputPreference());
		return searchedFlightList;
	}
	
	/**
	 * This method sort the list according to the given preference
	 * 
	 * @param outputPreference, preference according to which sorting perfrom
	 * 
	 * 
	 */
	private void resultOutputPreferences(String outputPreference){
		
		if(outputPreference.equals(Constants.SORT_BY_FARE)){
			searchedFlightList.sort(Comparator.comparing(Flight::getFare));
		} else {
			searchedFlightList.sort(Comparator.comparing(Flight::getFlightDuration).thenComparing(Flight::getFare));
		}	
	}
	
}
