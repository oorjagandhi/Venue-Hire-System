package nz.ac.auckland.se281;

public class Date {
  private int day;
  private int month;
  private int year;

  public Date(String date) {
    String[] dateParts = date.split("/");
    this.day = Integer.parseInt(dateParts[0]);
    this.month = Integer.parseInt(dateParts[1]);
    this.year = Integer.parseInt(dateParts[2]);
  }

  public boolean isBefore(Date otherDate) {
    // Checking if the year is after
    if (this.year > otherDate.year) {
      return false;
    }

    // Checking if the month is  after
    if (this.month > otherDate.month) {
      return false;
    }

    // Checking if the day is  after
    if (this.day > otherDate.day) {
      return false;
    }

    // Return true if the date is before
    return true;
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
