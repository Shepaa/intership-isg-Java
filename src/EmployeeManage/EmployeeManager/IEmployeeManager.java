package EmployeeManage.EmployeeManager;

import EmployeeManage.Employees.IEmployee;

public interface IEmployeeManager {
    void addNewEmployee(IEmployee employee);

    int calcSalary();

    void printEmployeesInfo();
}
