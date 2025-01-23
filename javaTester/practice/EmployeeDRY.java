package practice;

public class EmployeeDRY {
    private String employeeName;
    String employeePositions;
    String employeeType;
    String employeeSalary;
    String employeeRate;
    //Hàm khởi tạo bằng cách bấm generate --> contractors
    public EmployeeDRY(String employeeName, String employeePositions, String employeeType, String employeeSalary, String employeeRate) {
        this.employeeName = employeeName;
        this.employeePositions = employeePositions;
        this.employeeType = employeeType;
        this.employeeSalary = employeeSalary;
        this.employeeRate = employeeRate;
    }

    public void showEmployeeInfor() {
        System.out.println("Name = " + this.employeeName);
        System.out.println("Position = " + this.employeePositions);
        System.out.println("Type= "+ this.employeeType);
        if (this.employeeType.equalsIgnoreCase("Fulltime")){
            System.out.println("Salary =" + this.employeeSalary);
        } else {
            System.out.println("Rate= "+this.employeeRate);
        }
    }

    public static void main(String[] args) {
        EmployeeDRY kennyGy = new EmployeeDRY("KennyG","Developer", "Fulltime","5000","");
        kennyGy.showEmployeeInfor();
        EmployeeDRY johnWick = new EmployeeDRY("John Wick","QA","Parttime","6000","50");
        johnWick.showEmployeeInfor();



    }
}
