package skypro.course2.employeeBook.controller;

import org.springframework.web.bind.annotation.*;
import skypro.course2.employeeBook.model.Employee;
import skypro.course2.employeeBook.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //возвращает список сотрудников конкретного отдела
    @GetMapping("/{id}/employees")
    public Map<Integer, List<Employee>> getAllEmployeesByDep(@PathVariable("id")  Integer numOfDepartment) {
        return departmentService.getEmployeesListByDep(numOfDepartment);
    }

    //возвращает сумму зарплат сотрудников конкретного отдела
    @GetMapping("/{id}/salary/sum")
    public Integer getSumOfSalaryByDep(@PathVariable("id") Integer numOfDepartment) {
        return departmentService.getSumOfSalaryByDep(numOfDepartment);
    }

    //возвращает сотрудника с максимальной зарплатой в конкретном отделе
    @GetMapping("/{id}/salary/max")
    public Employee getEmployeeWithMaxSalaryOfDep(@PathVariable("id") Integer numOfDepartment) {
        return departmentService.getEmployeeWithMaxSalaryOfDep(numOfDepartment);
    }

    //возвращает сотрудника с минимальной зарплатой в конкретном отделе
    @GetMapping("/{id}/salary/min")
    public Employee getEmployeeWithMinSalaryOfDep(@PathVariable("id") Integer numOfDepartment) {
        return departmentService.getEmployeeWithMinSalaryOfDep(numOfDepartment);
    }

    //возвращает список всех сотрудников с разделением по отделам
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesOfDeps() {
        return departmentService.getAllEmployeesList();
    }
}
