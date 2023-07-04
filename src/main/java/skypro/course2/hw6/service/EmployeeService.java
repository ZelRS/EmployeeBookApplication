package skypro.course2.hw6.service;

import skypro.course2.hw6.model.Employee;


import java.util.List;


public interface EmployeeService {

    Employee addEmployee(int dep, String firstName, String lastName, int salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> showEmployeeList();
}
