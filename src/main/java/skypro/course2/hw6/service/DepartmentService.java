package skypro.course2.hw6.service;

import skypro.course2.hw6.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> getEmployeeWithMaxSalaryOfDep(Integer departmentId);

    Optional<Employee> getEmployeeWithMinSalaryOfDep(Integer departmentId);

    Map<Integer, List<Employee>> getAllEmployeesList(Integer departmentId);
}
