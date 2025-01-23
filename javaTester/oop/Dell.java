package oop;

public class Dell extends Computer {
   public void test(){
       cpu(); // gọi trực tiếp, ko cân thông qua 1 đối tượng khác
   }

    @Override
    public void ram() {

    }
}
