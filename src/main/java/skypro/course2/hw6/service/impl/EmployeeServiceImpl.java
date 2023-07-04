package skypro.course2.hw6.service.impl;

import org.springframework.stereotype.Service;
import skypro.course2.hw6.exception.EmployeeAlreadyAddedException;
import skypro.course2.hw6.exception.EmployeeNotFoundException;
import skypro.course2.hw6.exception.EmployeeStorageIsFullException;
import skypro.course2.hw6.model.Employee;
import skypro.course2.hw6.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private final int MAX_COUNT_OF_EMPLOYEES = 15;
    private final int DEP_COUNT = 5;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>(Map.of(
//                "Semen Semenov",
//                new Employee(1, "Semen", "Semenov", 179369),
//                "Ivan Ivanov",
//                new Employee(4, "Ivan", "Ivanov", 197349),
//                "Viktor Viktorov",
//                new Employee(2, "Viktor", "Viktorov", 101976),
//                "Matvey Matveev",
//                new Employee(1, "Matvey", "Matveev", 179134),
//                "Roman Romanov",
//                new Employee(3, "Roman", "Romanov", 164791),
//                "Egor Egorov",
//                new Employee(3, "Egor", "Egorov", 132976),
//                "Ahmed Ahmedov",
//                new Employee(4, "Ahmed", "Ahmedov", 119764),
//                "Stepan Stepanov",
//                new Employee(2, "Stepan", "Stepanov", 106791),
//                "Andrey Andreev",
//                new Employee(5, "Andrey", "Andreev", 100999),
//                "Kirill Kirillov",
//                new Employee(5, "Kirill", "Kirillov", 111971)
                ));
    }

    @Override
    public Employee addEmployee(int dep, String firstName, String lastName, int salary) {
        if (dep > 0 && dep <= DEP_COUNT) {
            Employee employee = new Employee(dep, firstName, lastName, salary);
            String key = firstName + " " + lastName;
            if (employees.size() >= MAX_COUNT_OF_EMPLOYEES) {
                throw new EmployeeStorageIsFullException("Нельзя добавить новго сотрудника. Список переполнен.");
            }
            if (employees.containsKey(key)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
            employees.put(key, employee);
            return employee;
        } else {
            throw new RuntimeException("Такого отдела не существует! В компании всего " + DEP_COUNT + " отделов.");
        }

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(key);
    }

    @Override
    public List<Employee> showEmployeeList() {
        return employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getNumOfDepartment))
                .collect(Collectors.toList());
    }
}
