package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;

public class Booking {

  private Venue venue;
  private Date bookingDate;
  private String customerEmail;
  private int attendees;
  private String bookingReference;
  private ArrayList<CateringType> cateringList = new ArrayList<CateringType>();

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

  public void addCatering(CateringType catering) {
    cateringList.add(catering);
  }

  public ArrayList<CateringType> getCateringList() {
    return cateringList;
  }
}
