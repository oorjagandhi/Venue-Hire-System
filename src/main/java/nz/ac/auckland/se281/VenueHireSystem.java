package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  ArrayList<Venue> venues = new ArrayList<Venue>();

  public VenueHireSystem() {}

  // Print the list of venues
  public void printVenues() {
    if (venues.isEmpty()){
      // Print message if there are no venues
      MessageCli.NO_VENUES.printMessage();
    } else if (venues.size() == 1){
      // Print message if there is one venue
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    } else if (venues.size() < 10){
      // Print message if there are less than 10 venues
      MessageCli.NUMBER_VENUES.printMessage("are", digitToWords(venues.size()), "s");
    } else {
      // Print message if there are 10 or more venues
      MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venues.size()), "s");
    }

    // Print the details of each venue
    for (Venue venue : venues){
      MessageCli.VENUE_ENTRY.printMessage(venue.getVenueName(), venue.getVenueCode(), venue.getCapacity(), venue.getHireFee());
    }
  }
  // Convert a number to words
  private String digitToWords(int num) {
    String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    if (num > 1 && num < 10){
      return words[num];
    }
    return Integer.toString(num);
  }



  // Method to create a new venue
  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // Check if the venue name is empty
    if (venueName == null || venueName.trim().isEmpty()){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    } 
    
    // Check if the venue code already exists
    for (Venue venue : venues){
      if (venue.getVenueCode().equals(venueCode)){
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venue.getVenueName());
        return;
      }
    }

    // Check if the capacity is positive
    try {
      int tempCapacity = Integer.parseInt(capacityInput);
      if (tempCapacity <= 0){
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        return;
      }
      // Check if the capacity is a number
    } catch (Exception e){
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    // Check if the hire fee is a positive number
    try {
      int tempHireFee = Integer.parseInt(hireFeeInput);
      if (tempHireFee <= 0){
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return;
      }
      // Check if the hire fee is a number
    } catch (Exception e){
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }
    
    // If all validations passed, create the venue
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    venues.add(newVenue);
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
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
