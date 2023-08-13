package skypro.course2.employeeBook.service.impl;

import org.springframework.stereotype.Service;
import skypro.course2.employeeBook.exception.*;
import skypro.course2.employeeBook.model.Employee;
import skypro.course2.employeeBook.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private static final int MAX_COUNT_OF_EMPLOYEES = 15;
    private static final int DEP_COUNT = 5;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    //геттер для максимального числа сотрудников
    public int getMAX_COUNT_OF_EMPLOYEES() {
        return MAX_COUNT_OF_EMPLOYEES;
    }

    //геттер для количества отделов
    public int getDEP_COUNT() {
        return DEP_COUNT;
    }

    //добавляет сотрудника в отдел и возвращает его
    @Override
    public Employee addEmployee(int numOfDep, String firstName, String lastName, int salary) {
        userDataValidation(firstName, lastName);
        numOfDepValidation(numOfDep);
        Employee employee = new Employee(numOfDep, firstName, lastName, salary);
        String key = firstName + " " + lastName;
        if (employees.size() >= MAX_COUNT_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Нельзя добавить нового сотрудника. Список переполнен.");
        }
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.put(key, employee);
        return employee;
    }

    //удаляет сотрудника из отдела и возвращает его
    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        userDataValidation(firstName, lastName);
        String key = firstName + " " + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(key);
    }

    // находит сотрудника по имени и фамилии и возвращает его
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        userDataValidation(firstName, lastName);
        String key = firstName + " " + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(key);
    }

    //возвращает список всех сотрудников
    @Override
    public List<Employee> showEmployeeList() {
        return employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getNumOfDepartment))
                .collect(Collectors.toList());
    }

    //выбрасывает исключение, если имя сотрудника написано некорректно
    private static void userDataValidation(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new WrongSymbolInputException();
        }
    }
    //выбрасывает исключение, если номер отдела задан некорректно
    public static void numOfDepValidation(int numOfDep) {
        if (numOfDep <= 0 || numOfDep > DEP_COUNT) {
            throw new DepCountException("Такого отдела не существует! В компании всего " + DEP_COUNT + " отделов.");
        }
    }
}
