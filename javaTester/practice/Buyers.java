package practice;

import commons.CarsFactory;

public class Buyers {
  public static void main(String[] args) {
    String carName = "Ford";
    Cars selectedCar = CarsFactory.carSelection(carName);
    selectedCar.CheckCar();
    selectedCar.driverCar();
    selectedCar.viewCar();

  }


}
