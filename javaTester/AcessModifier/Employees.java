package AcessModifier;

import java.math.BigDecimal;

public class Employees {
    public String name;
    protected double salary;
    private String department;
    public Employees (String name, double salary, String department){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment (String department) {
        this.department = department;
    }
}
