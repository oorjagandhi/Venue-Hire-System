package nz.ac.auckland.se281;

public class Date {
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  @Override
  public String toString() {

    if (day < 10 && month < 10) {
      return "0" + day + "/0" + month + "/" + year;
    }
    if (day < 10) {
      return "0" + day + "/" + month + "/" + year;
    }

    if (month < 10) {
      return day + "/0" + month + "/" + year;
    }

    return day + "/" + month + "/" + year;
  }
}
