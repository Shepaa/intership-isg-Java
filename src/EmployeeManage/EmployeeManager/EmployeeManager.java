package EmployeeManage.EmployeeManager;

import EmployeeManage.Employees.IEmployee;

import java.util.ArrayList;

public class EmployeeManager implements IEmployeeManager {
    private final ArrayList<IEmployee> employees = new ArrayList<>();

    public void addNewEmployee(IEmployee employee) {
        this.employees.add(employee);
    }

    public int calcSalary() {
        int totalSalary = 0;
        for (IEmployee employee : employees) {
            totalSalary += (int) employee.getSalary();
        }
        return totalSalary;
    }

    public ArrayList<IEmployee> getEmployees() {
        return employees;
    }

    public void printEmployeesInfo() {
        for (IEmployee employee : employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println();
        }
    }
}
