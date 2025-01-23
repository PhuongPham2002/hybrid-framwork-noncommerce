package keywords;

public class Students {
    String studentName;
    static int count = 0;
    public Students (String name){
        studentName = name;
        count++;
    }
    public static void getTotalStudents(){
        System.out.println("Total Students: "+ count);
    }

    public static void main(String[] args) {
        Students hocSinh = new Students("Hau");
        Students hocSinh1 = new Students("Phuong");
        Students.getTotalStudents();
        System.out.println("Student 1: "+ hocSinh.studentName);
    }
}
