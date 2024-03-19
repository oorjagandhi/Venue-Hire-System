package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  ArrayList<Venue> venues = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
    // TODO implement this method
    if (venues.isEmpty()){
      System.out.println("There are no venues in the system. Please create a venue first.");
    } else {

    }

  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    // Check if the venue name is empty
    if (venueName.trim().isEmpty()){
      System.out.println("Venue not created: venue name must not be empty.");
    } 
    
    // Checking if the venue codes has already been used
    for (Venue venue : venues){
      if (venue.getVenueCode().equals(venueCode)){
        System.out.println("Venue not created: code '" + venueCode + "' is already used for '" + venue.getVenueName() + "'.");
        return;
      }
    }

    // Check if the capacity is a number and is positive
    try {
      int tempCapacity = Integer.parseInt(capacityInput);
      if (tempCapacity <= 0){
        System.out.println("Venue not created: capacity must be a positive number.");
        return;
      }
    } catch (Exception e){
      System.out.println("Venue not created: capacity must be a number.");
    }

    // Check if the hire fee is a number and is positive
    try {
      int tempHireFee = Integer.parseInt(hireFeeInput);
      if (tempHireFee <= 0){
        System.out.println("Venue not created: hire fee must be a positive number.");
        return;
      }
    } catch (Exception e){
      System.out.println("Venue not created: hire fee must be a number.");
    }
    
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
