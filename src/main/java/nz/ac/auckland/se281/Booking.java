package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class Booking {

  private Venue venue;
  private Date bookingDate;
  private String customerEmail;
  private int attendees;
  private String bookingReference;
  private Date bookingCreationDate;
  private CateringType catering;
  private boolean hasMusicService;
  private FloralType floral;

  public Booking(
      Venue venue,
      Date bookingDate,
      String customerEmail,
      int attendees,
      Date bookingCreationDate) {
    this.venue = venue;
    this.bookingDate = bookingDate;
    this.customerEmail = customerEmail;
    this.attendees = attendees;
    this.bookingReference = BookingReferenceGenerator.generateBookingReference();
    this.bookingCreationDate = bookingCreationDate;
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

  public FloralType getFloral() {
    return floral;
  }

  public void setFloral(FloralType floral) {
    this.floral = floral;
  }

  public Date getBookingCreationDate() {
    return bookingCreationDate;
  }
}
