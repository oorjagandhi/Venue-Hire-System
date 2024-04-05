package nz.ac.auckland.se281;

public class MusicService extends Service {
  public MusicService() {
    super(500);
  }

  @Override
  public void addToBooking(Booking booking) {
    booking.addMusicService();
  }

  @Override
  public void printSuccessMessage(String bookingReference) {
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
  }
}
