package EmployeeManage.Employees;

public interface IEmployee {
    String getName();

    String getPosition();

    double getSalary();

    void editData(String newName, String newPosition, double newSalary);
}
