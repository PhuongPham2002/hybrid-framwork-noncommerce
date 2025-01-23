package AcessModifier;

public class Manager extends Employees {
    protected float bonus;

    public Manager(String name, double salary, String department, float bonus) {
        super(name, salary, department);
        this.bonus=bonus;
    }

    public void printSalaryWithBonus () {
        System.out.println("Total Salary: " + (salary+bonus));
    }

    @Override
    public void setDepartment(String department) {
        if (department != null && !department.isEmpty()) {
            super.setDepartment(department);
        } else {
            System.out.println("Invalid department");
        }
    }

    public static void main(String[] args) {
        Employees emp = new Employees("Hau", 1000,"IT");
        System.out.println("Name: "+ emp.name);
        System.out.println("Phòng: "+emp.getDepartment());
        System.out.println("Lương: "+ emp.salary);
        Manager man = new Manager("Phuong", 2000,"HR",500);
        man.printSalaryWithBonus();

    }

}
