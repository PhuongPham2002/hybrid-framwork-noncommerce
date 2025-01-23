package commons;

import practice.Cars;
import practice.Ford;
import practice.Honda;
import practice.Hyundai;

public class CarsFactory {
    public static Cars carSelection (String carName) {
        switch (carName){
            case "Honda":
                return new Honda();
            case "Hyundai":
                return new Hyundai();
            case "Ford":
                return new Ford();
            default:
                throw new RuntimeException("Car name is not valid" + carName);
        }

    }
}
