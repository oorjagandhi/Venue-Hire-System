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
    
    for (Venue venue : venues){
      if (venue.getVenueCode().equals(venueCode)){
        System.out.println("Venue not created: code '" + venueCode + "' is already used for '" + venue.getVenueName() + "'.");
        return;
      }

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
