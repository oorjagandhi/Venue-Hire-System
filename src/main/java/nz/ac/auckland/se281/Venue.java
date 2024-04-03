package nz.ac.auckland.se281;

public class Venue {
  private String venueName;
  private String venueCode;
  private String capacity;
  private String hireFee;
  private Date nextAvailablDate;

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

  public void setNextAvailablDate(Date nextAvailablDate) {
    this.nextAvailablDate = nextAvailablDate;
  }

  public Date getNextAvailablDate() {
    return nextAvailablDate;
  }
}
