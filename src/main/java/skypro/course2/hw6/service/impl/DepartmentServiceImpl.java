package skypro.course2.hw6.service.impl;

import org.springframework.stereotype.Service;
import skypro.course2.hw6.model.Employee;
import skypro.course2.hw6.service.DepartmentService;
import skypro.course2.hw6.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> getEmployeeWithMaxSalaryOfDep(Integer departmentId) {
        return employeeService.showEmployeeList()
                .stream()
                .filter(e -> e.getNumOfDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> getEmployeeWithMinSalaryOfDep(Integer departmentId) {
        return employeeService.showEmployeeList()
                .stream()
                .filter(e -> e.getNumOfDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesList(Integer departmentId) {
        if (departmentId == null) {
            return employeeService.showEmployeeList()
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getNumOfDepartment));
        } else {
            return employeeService.showEmployeeList()
                .stream()
                .filter(e -> e.getNumOfDepartment().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getNumOfDepartment));
        }
    }
}
