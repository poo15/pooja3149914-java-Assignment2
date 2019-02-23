package com.nagarro.java.Training.Assignment2.dto;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Flight {

	private String flightNo;
	private String departureLocation;
	private String arrivalLocation;
	private Date validTillDate;
	private String flightTime;
	private String flightDuration;
	private double fare;
	private String seatAvailability;
	private String flightclass;
	
	public Flight(String flightNo, String departureLocation, String arrivalLocation, Date validTillDate,
			String flightTime, String flightDuration, double fare, String seatAvailability, String flightclass) {
		this.flightNo = flightNo;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.validTillDate = validTillDate;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.seatAvailability = seatAvailability;
		this.flightclass = flightclass;
		this.setFare(fare);
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
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
	public Date getValidTillDate() {
		return validTillDate;
	}
	public void setValidTillDate(Date validTillDate) {
		this.validTillDate = validTillDate;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
			this.fare = fare;
	}
	public String getSeatAvailability() {
		return seatAvailability;
	}
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	public String getFlightclass() {
		return flightclass;
	}
	public void setFlightclass(String flightclass) {
		this.flightclass = flightclass;
	}
	
	
	@Override
	public String toString() {
		String date = new SimpleDateFormat("dd-MM-yyyy").format(this.validTillDate);
		return this.flightNo+" \t\t "+this.departureLocation+" \t\t"+this.arrivalLocation+" \t\t"+date
		+" \t\t "+this.flightTime +" \t\t "+this.flightDuration+" \t\t "+this.fare;
	}
	
}