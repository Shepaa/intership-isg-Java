package EmployeeManage;

import EmployeeManage.EmployeeManager.EmployeeManager;
import EmployeeManage.Employees.Accountants;
import EmployeeManage.Employees.Engineer;
import EmployeeManage.Employees.Manager;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("John", "Junior", 1000);
        Accountants accountants = new Accountants("Tom", "Middle", 2500);
        Engineer engineer = new Engineer("Dima", "CEO", 10000);

        EmployeeManager employeeManager = new EmployeeManager();

        employeeManager.addNewEmployee(manager);
        employeeManager.addNewEmployee(accountants);
        employeeManager.addNewEmployee(engineer);


        employeeManager.printEmployeesInfo();
        System.out.println(employeeManager.calcSalary());
    }
}
