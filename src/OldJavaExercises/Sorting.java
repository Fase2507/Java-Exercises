//Java File Handling


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {
  public static void main(String[] args) {
    // Create a list of cars
    ArrayList<Car> myCars = new ArrayList<Car>();
    myCars.add(new Car("BMW", "X5", 1999));
    myCars.add(new Car("Honda", "Accord", 2006));
    myCars.add(new Car("Ford", "Mustang", 1970));

    // Use a comparator to sort the cars
    Comparator<Car> myComparator = new SortByYear();
    Collections.sort(myCars, myComparator);

    // Display the cars
    for (Car c : myCars) {
      System.out.println(c.brand + " " + c.model + " " + c.year);
    }
  }
}

// Create a comparator
class SortByYear implements Comparator<Car> {
  @Override
  public int compare(Car a, Car b) {
    // Compare the year of both objects
    if (a.year < b.year) return -1; // The first car has a smaller year
    if (a.year > b.year) return 1;  // The first car has a larger year
    return 0; // Both cars have the same year
  }
}

// Define a Car class
class Car {
  public String brand;
  public String model;
  public int year;

  public Car(String b, String m, int y) {
    brand = b;
    model = m;
    year = y;
  }
}