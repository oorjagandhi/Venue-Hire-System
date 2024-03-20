package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  ArrayList<Venue> venues = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
    if (venues.isEmpty()){
      System.out.println("There are no venues in the system. Please create a venue first.");
    } else if (venues.size() == 1){
      System.out.println("There is one venue in the system:");
    } else if (venues.size() < 10){
      System.out.println("There are " + digitToWords(venues.size()) + " venues in the system:");
    } else {
      System.out.println("There are " + venues.size() + " venues in the system:");
    }

    for (Venue venue : venues){
      System.out.println("  * " + venue.getVenueName() + " (" + venue.getVenueCode() + ") - " + venue.getCapacity() + " people - $" + venue.getHireFee() + " base hire fee. Next available on");
    }
  }

  private String digitToWords(int num) {
    String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    if (num > 1 && num < 10){
      return words[num];
    }
    return Integer.toString(num);
  }




  public void createVenue(
    String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    if (venueName == null || venueName.trim().isEmpty()){
      System.out.println("Venue not created: venue name must not be empty.");
      return;
    } 
    
    for (Venue venue : venues){
      if (venue.getVenueCode().equals(venueCode)){
        System.out.println("Venue not created: code '" + venueCode + "' is already used for '" + venue.getVenueName() + "'.");
        return;
      }
    }

    try {
      int tempCapacity = Integer.parseInt(capacityInput);
      if (tempCapacity <= 0){
        System.out.println("Venue not created: capacity must be a positive number.");
        return;
      }
    } catch (Exception e){
      System.out.println("Venue not created: capacity must be a number.");
      return;
    }

    try {
      int tempHireFee = Integer.parseInt(hireFeeInput);
      if (tempHireFee <= 0){
        System.out.println("Venue not created: hire fee must be a positive number.");
        return;
      }
    } catch (Exception e){
      System.out.println("Venue not created: hire fee must be a number.");
      return;
    }
    
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    venues.add(newVenue);
    System.out.println("Successfully created venue '" + venueName + "' (" + venueCode + ").");

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
