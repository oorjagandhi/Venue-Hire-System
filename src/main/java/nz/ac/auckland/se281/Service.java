package nz.ac.auckland.se281;

public abstract class Service {
  protected int cost;

  public Service(int cost) {
    this.cost = cost;
  }

  public int getCost() {
    return cost;
  }

  public abstract void addToBooking(Booking booking);

  public abstract void printSuccessMessage(String bookingReference);
}
