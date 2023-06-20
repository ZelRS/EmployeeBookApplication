package skypro.course2.hw6.service;

import org.springframework.stereotype.Service;
import skypro.course2.hw6.exception.EmployeeAlreadyAddedException;
import skypro.course2.hw6.exception.EmployeeNotFoundException;
import skypro.course2.hw6.exception.EmployeeStorageIsFullException;
import skypro.course2.hw6.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> listOfEmployee = new ArrayList<>();
    private final int maxCountOfEmployees = 3;

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (listOfEmployee.size() >= maxCountOfEmployees) {
            throw new EmployeeStorageIsFullException("Нельзя добавить новго сотрудника. Список переполнен.");
        }
        if (listOfEmployee.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        listOfEmployee.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!listOfEmployee.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        listOfEmployee.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!listOfEmployee.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Collection<Employee> showEmployeeList() {
        return Collections.unmodifiableList(listOfEmployee);
    }
}
