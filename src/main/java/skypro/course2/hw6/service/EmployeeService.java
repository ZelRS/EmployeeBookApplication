package skypro.course2.hw6.service;

import skypro.course2.hw6.model.Employee;

import java.util.Collection;


public interface EmployeeService {

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> showEmployeeList();
}
