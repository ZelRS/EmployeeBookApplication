package skypro.course2.hw6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.course2.hw6.model.Employee;
import skypro.course2.hw6.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryOfDep(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalaryOfDep(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryOfDep(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMinSalaryOfDep(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeesOfDepOrEverybody(@RequestParam(required = false) Integer departmentId) {
            return departmentService.getAllEmployeesList(departmentId);
    }
}
