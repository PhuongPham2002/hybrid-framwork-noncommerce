package practice;

public class EmployeeRY {
    public void showFulltimeEmployeeKennyGDetail(){
        System.out.println("Employee Name= Kenny G");
        System.out.println("Employee Type= Fulltime ");
        System.out.println("Employee Position= Developer ");
        System.out.println("Employee Salary= 4000");


    }
    public void showFulltimeEmployeeJohnWickDetail() {
        System.out.println("Employee Name= John Wick");
        System.out.println("Employee Type= Fulltime ");
        System.out.println("Employee Position= Developer ");
        System.out.println("Employee Salary= 4000");
    }
    public void showParttimeEmployeeVinnothDetail(){
        System.out.println("Employee Name= Vinnoth");
        System.out.println("Employee Type= Parttime ");
        System.out.println("Employee Position= QA ");
        System.out.println("Employee Rate=20 ");
    }
    public static void main(String[] args) {
        EmployeeRY firstEmployee = new EmployeeRY();
        firstEmployee.showParttimeEmployeeVinnothDetail();
        EmployeeRY secondEmployee = new EmployeeRY();
        secondEmployee.showFulltimeEmployeeKennyGDetail();
    }
}
