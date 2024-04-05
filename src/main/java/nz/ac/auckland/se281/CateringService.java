package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class CateringService extends Service {
  private CateringType type;

  public CateringService(CateringType type) {
    super(type.getCostPerPerson());
    this.type = type;
  }

  @Override
  public void addToBooking(Booking booking) {
    booking.setCatering(type);
  }

  @Override
  public void printSuccessMessage(String bookingReference) {
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(
        "Catering (" + type.getName() + ")", bookingReference);
  }
}
