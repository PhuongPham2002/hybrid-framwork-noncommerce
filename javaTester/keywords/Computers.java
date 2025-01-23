package keywords;

public class Computers {
    int id;
    static String labName;
    static int totalComputers=0;
    public Computers(int id){
        this.id = id;
        totalComputers ++;
    }
    public void displayInfo(){
        System.out.println("Tên phòng lab: " +labName +",ID máy: " + id );

    }
    public static void changeLabName(String name){

    }

}
