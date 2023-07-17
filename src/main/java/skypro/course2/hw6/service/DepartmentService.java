package skypro.course2.hw6.service;

import skypro.course2.hw6.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalaryOfDep(Integer departmentId);

    Employee getEmployeeWithMinSalaryOfDep(Integer departmentId);

    Map<Integer, List<Employee>> getAllEmployeesList(Integer departmentId);
}
