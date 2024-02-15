package EmployeeManage.Employees;

public class Manager implements IEmployee {
    private String name;
    private String position;
    private double salary;

    public Manager(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public double getSalary() {
        return this.salary;
    }

    public void editData(String newName, String newPosition, double newSalary) {
        this.name = newName;
        this.position = newPosition;
        this.salary = newSalary;
    }
}
