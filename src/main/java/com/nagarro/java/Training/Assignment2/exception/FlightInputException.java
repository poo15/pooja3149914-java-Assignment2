/*
* 
* @author pooja01 
* @version 0.0.1-SNAPSHOT
*/
package com.nagarro.java.Training.Assignment2.exception;

public class FlightInputException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public FlightInputException(String userInputException){
		super(userInputException);
	}
}
