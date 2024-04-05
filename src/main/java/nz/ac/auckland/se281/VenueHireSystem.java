package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  ArrayList<Venue> venues = new ArrayList<Venue>();
  ArrayList<Booking> bookings = new ArrayList<Booking>();

  private Date systemDate = null;

  public VenueHireSystem() {}

  // Print the list of venues
  public void printVenues() {
    if (venues.isEmpty()) {
      // Print message if there are no venues
      MessageCli.NO_VENUES.printMessage();
    } else if (venues.size() == 1) {
      // Print message if there is one venue
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    } else if (venues.size() < 10) {
      // Print message if there are less than 10 venues
      MessageCli.NUMBER_VENUES.printMessage("are", digitToWords(venues.size()), "s");
    } else {
      // Print message if there are 10 or more venues
      MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venues.size()), "s");
    }

    // Print the details of each venue
    for (Venue venue : venues) {
      Date nextAvailableDate = venue.getNextAvailableDate(bookings, systemDate);
      String nextAvailableDateStr;
      if (nextAvailableDate == null) {
        nextAvailableDateStr = "";
      } else {
        nextAvailableDateStr = nextAvailableDate.toString();
      }
      MessageCli.VENUE_ENTRY.printMessage(
          venue.getVenueName(),
          venue.getVenueCode(),
          venue.getCapacity(),
          venue.getHireFee(),
          nextAvailableDateStr);
    }
  }

  // Convert a number to words
  private String digitToWords(int num) {
    String[] words = {
      "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    if (num > 1 && num < 10) {
      return words[num];
    }
    return Integer.toString(num);
  }

  // Method to create a new venue
  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // Check if the venue name is empty
    if (venueName == null || venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // Check if the venue code already exists
    for (Venue venue : venues) {
      if (venue.getVenueCode().equals(venueCode)) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venue.getVenueName());
        return;
      }
    }

    // Check if the capacity is positive
    try {
      int tempCapacity = Integer.parseInt(capacityInput);
      if (tempCapacity <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        return;
      }
      // Check if the capacity is a number
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    // Check if the hire fee is a positive number
    try {
      int tempHireFee = Integer.parseInt(hireFeeInput);
      if (tempHireFee <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return;
      }
      // Check if the hire fee is a number
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    // If all validations passed, create the venue
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);

    venues.add(newVenue);
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

  // Setting the system date
  public void setSystemDate(String date) {
    systemDate = new Date(date);
    MessageCli.DATE_SET.printMessage(systemDate.toString());
  }

  // Printing the system date
  public void printSystemDate() {
    if (systemDate == null) {
      System.out.println("Current system date is not set.");
    } else {
      MessageCli.CURRENT_DATE.printMessage(systemDate.toString());
    }
  }

  // Making a booking
  public void makeBooking(String[] options) {
    // Check if the system date is set
    if (systemDate == null) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }

    // Check if there are venues
    if (venues.isEmpty()) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }

    // Check to see if the venue code exists
    Venue bookingVenue = null;
    for (Venue venue : venues) {
      if (venue.getVenueCode().equals(options[0])) {
        bookingVenue = venue;
        break;
      }
    }

    // If the venue code does not exist, print error message.
    if (bookingVenue == null) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      return;
    }

    // Converting the input date into a Date object
    Date bookingDate = new Date(options[1]);

    // Check if the booking date is after the system date
    if (bookingDate.isBefore(systemDate)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate.toString());
      return;
    }

    // Check if the booking date is already booked
    for (Booking booking : bookings) {
      if (booking.getVenue().getVenueCode().equals(options[0])
          && booking.getBookingDate().isEqual(bookingDate)) {
        MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(
            bookingVenue.getVenueName(), bookingDate.toString());
        return;
      }
    }

    // Adjusting the attendees if the number of attendees is less than 25% of capacity
    int attendees = Integer.parseInt(options[3]);
    int capacity = Integer.parseInt(bookingVenue.getCapacity());
    if (attendees < 0.25 * capacity) {
      attendees = (int) (0.25 * capacity);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
          options[3], Integer.toString(attendees), Integer.toString(capacity));
    }

    // Adjusting the attendees if the number of attendees is more than 100% of the capacity
    if (attendees > capacity) {
      attendees = capacity;
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
          options[3], Integer.toString(attendees), Integer.toString(capacity));
    }

    // If all validations passed, create the booking
    Booking newBooking = new Booking(bookingVenue, bookingDate, options[2], attendees);

    bookings.add(newBooking);
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
        newBooking.getBookingReference(),
        newBooking.getVenue().getVenueName(),
        newBooking.getBookingDate().toString(),
        Integer.toString(newBooking.getAttendees()));
  }

  public void printBookings(String venueCode) {
    // Check if there are venues
    Venue foundVenue = null;
    for (Venue venue : venues) {
      if (venue.getVenueCode().equals(venueCode)) {
        foundVenue = venue;
        break;
      }
    }

    // If the venue code does not exist, print error message.
    if (foundVenue == null) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    }

    // If there are no bookings for the venue, print message
    if (bookings.isEmpty()) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(foundVenue.getVenueName());
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(foundVenue.getVenueName());
      return;
    }

    // Print the bookings for the venue
    boolean hasBooking = false;
    MessageCli.PRINT_BOOKINGS_HEADER.printMessage(foundVenue.getVenueName());
    for (Booking booking : bookings) {
      if (booking.getVenue().getVenueCode().equals(venueCode)) {
        MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(
            booking.getBookingReference(), booking.getBookingDate().toString());
        hasBooking = true;
      }
    }

    if (!hasBooking) {
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(foundVenue.getVenueName());
    }
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // Find the booking by reference
    Booking booking = null;
    for (Booking b : bookings) {
      if (b.getBookingReference().equals(bookingReference)) {
        booking = b;
        break;
      }
    }

    // If the booking is not found, print error message
    if (booking == null) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
      return;
    }

    // If the booking is found, add the catering service
    booking.setCatering(cateringType);
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(
        "Catering (" + cateringType.getName() + ")", bookingReference);
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method

    Booking booking = null;
    for (Booking b : bookings) {
      if (b.getBookingReference().equals(bookingReference)) {
        booking = b;
        break;
      }
    }

    // If the booking is not found, print error message
    if (booking == null) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
      return;
    }

    // If the booking is found, add the catering service
    booking.addMusicService();
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
