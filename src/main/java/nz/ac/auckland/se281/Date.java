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

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public boolean isBefore(Date otherDate) {
    // Checking if the year is after
    if (this.year < otherDate.year) {
      return true;
    } else if (this.year == otherDate.year && this.month < otherDate.month) {
      return true;
    } else if (this.year == otherDate.year
        && this.month == otherDate.month
        && this.day < otherDate.day) {
      return true;
    }
    // Return false if the date is before
    return false;
  }

  public boolean isEqual(Date otherDate) {
    // Checking if the year is equal
    if (this.year != otherDate.year) {
      return false;
    }
    // Checking if the month is equal
    if (this.month != otherDate.month) {
      return false;
    }
    // Checking if the day is equal
    if (this.day != otherDate.day) {
      return false;
    }
    // Return true if the date is equal
    return true;
  }

  // Increment the date by one day
  public Date increment() {
    return new Date(this.day + 1, this.month, this.year);
  }

  // toString method to return the date in the format dd/mm/yyyy
  @Override
  public String toString() {

    // Checking if the day and month are less than 10
    if (day < 10 && month < 10) {
      return "0" + day + "/0" + month + "/" + year;
    }
    // Checking if the day is less than 10
    if (day < 10) {
      return "0" + day + "/" + month + "/" + year;
    }

    // Checking if the month is less than 10
    if (month < 10) {
      return day + "/0" + month + "/" + year;
    }

    return day + "/" + month + "/" + year;
  }
}
