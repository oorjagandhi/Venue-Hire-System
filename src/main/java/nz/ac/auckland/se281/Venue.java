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
    ArrayList<Date> venueBookingDates = new ArrayList<Date>();

    for (Booking venueBooking : bookings) {
      if (venueBooking.getVenue().getVenueCode().equals(this.venueCode)) {
        venueBookingDates.add(venueBooking.getBookingDate());
      }
    }

    for (Date bookingDate : venueBookingDates) {
      if (bookingDate.isEqual(systemDate)) {
        nextAvailableDate = nextAvailableDate.increment();
      }
    }
    return nextAvailableDate;
  }
}
