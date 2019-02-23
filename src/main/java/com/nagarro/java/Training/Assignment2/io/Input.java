package com.nagarro.java.Training.Assignment2.io;


import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.nagarro.java.Training.Assignment2.constants.Constants;
import com.nagarro.java.Training.Assignment2.dto.FlightSearchParameter;
import com.nagarro.java.Training.Assignment2.validation.FlightSearchInputValidation;

public class Input {

	FlightSearchInputValidation inputvalidation = new FlightSearchInputValidation();
	FlightSearchParameter flightSearchParameterObject = new FlightSearchParameter();
	SimpleDateFormat standardDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Takes the input for search a flight , and call the validations
	 * functions for validate the input
	 * 
	 * @return flightSearchParameter  the object of {@link FlightSearchParameter}.
	 */
	
	public FlightSearchParameter getSearchDetails(){
		System.out.println(Constants.ENTER_DEPARTURE_LOCATION);
		validateDepartureLocation(scanner.nextLine());
		System.out.println(Constants.ENTER_ARRIVAL_LOCATION);
		validateArrivalLocation(scanner.nextLine());
		System.out.println(Constants.ENTER_CLASS);
		validateClass(scanner.nextLine());
		System.out.println(Constants.ENTER_DATE);
		validateDate(scanner.nextLine());
		System.out.println(Constants.ENTER_OUTPUT_PREFERENCE);
		validateOutputPreference(scanner.nextLine());
		return flightSearchParameterObject;
	}
	
	/**
	 * This method continuously calls the validate departure function of FlightSearchInputValidatin class till 
	 *  valid departure location
	 *  @param departureLocation ,the location from where user wants to fly
	 */
	public void validateDepartureLocation(String departureLocation){
		
		while(true){
			if(inputvalidation.validateDepartureLocation(departureLocation)) {
				flightSearchParameterObject.setDepartureLocation(departureLocation);
				break;
			} else{
				departureLocation=scanner.nextLine();
			}	
		}	
	}
	
	/**
	 * This method continuously calls the validate arrival function of FlightSearchInputValidatin class till 
	 *  valid arrival location
	 *  @param arrivalLocation ,the location where user wants to  fly
	 */
	public void validateArrivalLocation(String arrivalLocation){
		
		while(true){
			if(inputvalidation.validateArrivalLocation(arrivalLocation)){
				flightSearchParameterObject.setArrivalLocation(arrivalLocation);
				break;
			} else {
				arrivalLocation = scanner.nextLine();
			}
		}
	}
	
	/**
	 * This method continuously calls the validate class function of FlightSearchInputValidatin class till 
	 *  valid class is entered
	 *  @param flightClass ,the class which user wants to fly
	 */
	public void validateClass(String flightClass){
		
		while(true){
			if(inputvalidation.validateClass(flightClass)){
				flightSearchParameterObject.setFlightclass(flightClass);
				break;
			} else {
				flightClass = scanner.nextLine();
			}
		}
	}
	
	/**
	 * This method continuously calls the validate date function of FlightSearchInputValidatin class till 
	 *  valid date in format dd-MM-yyyy is enter
	 *  @param date ,the date on which user wants to fly
	 */
	public void validateDate(String date){
		
		while(true){
			if(inputvalidation.validateDate(date)){
				flightSearchParameterObject.setFlightDate(date);
				break;
			} else {
				date = scanner.nextLine();
			}
		}
	}
	
	/**
	 * This method continuously calls the validate output preference function of FlightSearchInputValidatin class till 
	 *  valid preference enters
	 *  @param outputPreference ,the preference of the output
	 */
	public void validateOutputPreference(String outputPreference){
		
		while(true){
			if(inputvalidation.validateOutputPreference(outputPreference)){
				flightSearchParameterObject.setOutputPreference(outputPreference);
				break;
			} else {
				outputPreference = scanner.nextLine();
			}
		}
	}
	
}
