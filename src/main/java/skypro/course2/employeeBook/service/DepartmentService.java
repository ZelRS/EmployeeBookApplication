package skypro.course2.employeeBook.service;

import skypro.course2.employeeBook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    //возвращает работника с максимальной зарплатой в отделе
    Employee getEmployeeWithMaxSalaryOfDep(Integer numOfDepartment);

    //возвращает сотрудника с минимальной зарплатой в отделе
    Employee getEmployeeWithMinSalaryOfDep(Integer numOfDepartment);

    //возвращает списко сотрудника конкретного отдела
    Map<Integer, List<Employee>> getEmployeesListByDep(Integer numOfDepartment);

    //возвращает список всех сотрудников с разделением по отделам
    Map<Integer, List<Employee>> getAllEmployeesList();

    //возвращает сумму зарплат сотрудников конкретного отдела
    Integer getSumOfSalaryByDep(Integer numOfDepartment);
}
