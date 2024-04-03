package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Venue {
  private String venueName;
  private String venueCode;
  private String capacity;
  private String hireFee;

  public Venue(String venueName, String venueCode, String capacity, String hireFee) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = capacity;
    this.hireFee = hireFee;
  }

  public String getVenueName() {
    return venueName;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public String getCapacity() {
    return capacity;
  }

  public String getHireFee() {
    return hireFee;
  }

  public Date getNextAvailableDate(ArrayList<Booking> bookings, Date systemDate) {
    Date nextAvailableDate = systemDate;
    boolean isAvailable;

    // While loop to find the next available date, will break when date found
    while (true) {
      // Assume the date is available until found otherwise
      isAvailable = true;

      // Iterate over each booking
      for (Booking booking : bookings) {
        // Check if the booking belongs to this venue and matches the date
        if (this.venueCode.equals(booking.getVenue().getVenueCode())
            && booking.getBookingDate().isEqual(nextAvailableDate)) {
          nextAvailableDate = nextAvailableDate.increment();
          isAvailable = false;
          break;
        }
      }

      if (isAvailable) {
        break;
      }
    }
    return nextAvailableDate;
  }
}
