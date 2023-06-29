package skypro.course2.hw6.service;

import org.springframework.stereotype.Service;
import skypro.course2.hw6.exception.EmployeeAlreadyAddedException;
import skypro.course2.hw6.exception.EmployeeNotFoundException;
import skypro.course2.hw6.exception.EmployeeStorageIsFullException;
import skypro.course2.hw6.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> EMPLOYEES;
    private final int MAX_COUNT_OF_EMPLOYEES = 3;

    public EmployeeServiceImpl() {
        this.EMPLOYEES = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = firstName + " " + lastName;
        if (EMPLOYEES.size() >= MAX_COUNT_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Нельзя добавить новго сотрудника. Список переполнен.");
        }
        if (EMPLOYEES.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        EMPLOYEES.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        if (!EMPLOYEES.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return EMPLOYEES.remove(key);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        if (!EMPLOYEES.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return EMPLOYEES.get(key);
    }

    @Override
    public Collection<Employee> showEmployeeList() {
        return Collections.unmodifiableCollection(EMPLOYEES.values());
    }
}
