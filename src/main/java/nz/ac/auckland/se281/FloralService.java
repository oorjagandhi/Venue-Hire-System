package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class FloralService extends Service {
  private FloralType floralType;

  public FloralService(FloralType floralType) {
    super(floralType.getCost());
    this.floralType = floralType;
  }

  @Override
  public void addToBooking(Booking booking) {
    booking.setFloral(floralType);
  }
}
