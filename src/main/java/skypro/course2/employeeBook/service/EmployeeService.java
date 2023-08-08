package skypro.course2.employeeBook.service;

import skypro.course2.employeeBook.model.Employee;


import java.util.List;


public interface EmployeeService {
    //добавляет сотрудника в отдел и возвращает его
    Employee addEmployee(int dep, String firstName, String lastName, int salary);

    //удаляет сотрудника из отдела и возвращает его
    Employee removeEmployee(String firstName, String lastName);

    // находит сотрудника по имени и фамилии и возвращает его
    Employee findEmployee(String firstName, String lastName);

    //возвращает список всех сотрудников
    List<Employee> showEmployeeList();
}
