package com.nagarro.java.Training.Assignment2.dto;


public class FlightSearchParameter {
	
	
	private String departureLocation;
	private String arrivalLocation;
	private String flightDate;
	private String flightclass;
	private String outputPreference;
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightclass() {
		return flightclass;
	}
	public void setFlightclass(String flightclass) {
		this.flightclass = flightclass;
	}
	public String getOutputPreference() {
		return outputPreference;
	}
	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.departureLocation+"\t"+this.arrivalLocation+"\t"+this.flightclass+"\t"+this.flightDate+"\t"+this.outputPreference;
	}
	
}
