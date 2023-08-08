package skypro.course2.employeeBook.service.impl;

import org.springframework.stereotype.Service;
import skypro.course2.employeeBook.exception.EmployeeNotFoundException;
import skypro.course2.employeeBook.model.Employee;
import skypro.course2.employeeBook.service.DepartmentService;
import skypro.course2.employeeBook.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static skypro.course2.employeeBook.service.impl.EmployeeServiceImpl.numOfDepValidation;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //возвращает сотрудника с максимальной зарплатой в отделе
    @Override
    public Employee getEmployeeWithMaxSalaryOfDep(Integer numOfDepartment) {
        numOfDepValidation(numOfDepartment);
        return employeeService.showEmployeeList()
                .stream()
                .filter(e -> e.getNumOfDepartment().equals(numOfDepartment))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    //возвращает сотрудника с минимальной зарплатой в отделе
    @Override
    public Employee getEmployeeWithMinSalaryOfDep(Integer numOfDepartment) {
        numOfDepValidation(numOfDepartment);
        return employeeService.showEmployeeList()
                .stream()
                .filter(e -> e.getNumOfDepartment().equals(numOfDepartment))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден!"));
    }

    //возвращает список сотрудников конкретного отдела
    @Override
    public Map<Integer, List<Employee>> getEmployeesListByDep(Integer numOfDepartment) {
        numOfDepValidation(numOfDepartment);
        return employeeService.showEmployeeList()
                .stream()
                .filter(e -> e.getNumOfDepartment().equals(numOfDepartment))
                .collect(Collectors.groupingBy(Employee::getNumOfDepartment));
    }

    //возвращает список всех сотрудников с разделением по отделам
    @Override
    public Map<Integer, List<Employee>> getAllEmployeesList() {
        return employeeService.showEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getNumOfDepartment));
    }

    //возвращает сумму зарплат сотрудников конкретного отдела
    @Override
    public Integer getSumOfSalaryByDep(Integer numOfDepartment) {
        numOfDepValidation(numOfDepartment);
        return employeeService.showEmployeeList()
                .stream()
                .filter(e -> e.getNumOfDepartment().equals(numOfDepartment))
                .mapToInt(Employee::getSalary)
                .sum();

    }
}
