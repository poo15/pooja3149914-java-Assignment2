/*
* 
* @author pooja01 
* @version 0.0.1-SNAPSHOT
*/
package com.nagarro.java.Training.Assignment2.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.nagarro.java.Training.Assignment2.constants.Constants;
import com.nagarro.java.Training.Assignment2.exception.FlightInputException;

public class FlightSearchInputValidation {
	
	/**
	 * This methods checks departure location is of length 3 
	 * 
	 * @param departureLocation
	 * 						
	 * @return boolean
	 */
	
	public boolean validateDepartureLocation(String departureLocation){
		
		try{
			if(departureLocation.length()==3)
				return true;
			else
				throw new FlightInputException(Constants.ENTER_DEPARTURE_LOCATION);
		} catch(FlightInputException departureLocationException) {
			System.out.println(departureLocationException.getMessage());
		}
		
		return false;
	}
	
	/**
	 * This methods checks arrival location is of length 3 
	 * 
	 * @param arrivalLocation
	 * 						
	 * @return boolean
	 */
	public boolean validateArrivalLocation(String arrivalLocation){
			
			try{
				if(arrivalLocation.length()==3)
					return true;
				else
					throw new FlightInputException(Constants.ENTER_ARRIVAL_LOCATION);
			} catch(FlightInputException arrivalLocationException) {
				System.out.println(arrivalLocationException.getMessage());
			}
			
			return false;
	}
	
	/**
	 * This methods checks flight class 
	 * 
	 * @param flightClass
	 * 						
	 * @return boolean
	 */
	public boolean validateClass(String flightClass){
		
		try{
			if(flightClass.equalsIgnoreCase(Constants.ECONOMIC)||flightClass.equalsIgnoreCase(Constants.BUSSINESS))
				return true;
			else
				throw new FlightInputException(Constants.ENTER_CLASS);
		} catch(FlightInputException flightClassException) {
			System.out.println(flightClassException.getMessage());
		}
		
		return false;
	}
	
	/**
	 * This methods checks date is valid 
	 * 
	 * @param date
	 * 						
	 * @return boolean
	 */
	public boolean validateDate(String date){
		SimpleDateFormat sdfrmt = new SimpleDateFormat(Constants.DATE_FORMAT);
		try{
			sdfrmt.parse(date);
		} catch(ParseException flightDateException) {
			System.out.println(Constants.ENTER_VALID_DATE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * This methods checks output preference is valid
	 * 
	 * @param outputPreference
	 * 						
	 * @return boolean
	 */
	public boolean validateOutputPreference(String outputPreference){
			
			try{
				if(outputPreference.equals(Constants.SORT_BY_FARE)
						||outputPreference.equals(Constants.SORT_BY_FARE_DURATION))
					return true;
				else
					throw new FlightInputException(Constants.ENTER_OUTPUT_PREFERENCE);
			} catch(FlightInputException outputPreferenceException) {
				System.out.println(outputPreferenceException.getMessage());
			}
			
			return false;
	}
	
}
