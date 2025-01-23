package keywords;

import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

/**
 * Class syntax: Class + Name + {}, không có parameters,  nếu ko có access modifier thì để mặc định là default
 * <br> Method syntax: Access modifier (opt)
 */

 class Class_Related_Keywords {
     String nameAddress;
     String name;
     String address;

     public void example () {
         name="Nhat Minh";
         address = "Cau Coc";
         nameAddress = name +" " +address;
         System.out.println(nameAddress);
     }

    public static void main(String[] args) {
         Class_Related_Keywords running = new Class_Related_Keywords();
         running.example();
    }
}
