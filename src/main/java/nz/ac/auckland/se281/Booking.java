package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Booking {

  private Venue venue;
  private Date bookingDate;
  private String customerEmail;
  private int attendees;
  private String bookingReference;
  private CateringType catering;
  private boolean hasMusicService;

  public Booking(Venue venue, Date bookingDate, String customerEmail, int attendees) {
    this.venue = venue;
    this.bookingDate = bookingDate;
    this.customerEmail = customerEmail;
    this.attendees = attendees;
    this.bookingReference = BookingReferenceGenerator.generateBookingReference();
  }

  public Venue getVenue() {
    return venue;
  }

  public Date getBookingDate() {
    return bookingDate;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public int getAttendees() {
    return attendees;
  }

  public String getBookingReference() {
    return bookingReference;
  }

  public CateringType getCatering() {
    return catering;
  }

  public void setCatering(CateringType catering) {
    this.catering = catering;
  }

  public void addMusicService() {
    hasMusicService = true;
  }

  public boolean hasMusicService() {
    return hasMusicService;
  }
}
