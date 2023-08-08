package skypro.course2.employeeBook.constants;

import skypro.course2.employeeBook.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceImplTestConstants {

    public static final Employee EMPLOYEE1 = new Employee(1, "Semen",
            "Semenov", 180369);
    public static final Employee EMPLOYEE2 = new Employee(1, "Matvey",
            "Matveev", 179134);
    public static final Employee EMPLOYEE3 = new Employee(2, "Ivan",
            "Ivanov", 197349);
    public static final Employee EMPLOYEE4 = new Employee(2, "Viktor",
            "Viktorov", 101976);
    public static final Employee EMPLOYEE5 = new Employee(3, "Roman",
            "Romanov", 164791);
    public static final Employee EMPLOYEE6 = new Employee(3, "Egor",
            "Egorov", 132976);
    public static final Employee EMPLOYEE7 = new Employee(4, "Ahmed",
            "Ahmedov", 119764);
    public static final Employee EMPLOYEE8 = new Employee(4, "Stepan",
            "Stepanov", 106791);
    public static final Employee EMPLOYEE9 = new Employee(5, "Andrey",
            "Andreev", 100999);
    public static final Employee EMPLOYEE10 = new Employee(5, "Kirill",
            "Kirillov", 111971);

    public static final List<Employee> CONSTANT_LIST_OF_EMPLOYEE = new ArrayList<>(List.of(EMPLOYEE1,
            EMPLOYEE2, EMPLOYEE3, EMPLOYEE4, EMPLOYEE5, EMPLOYEE6, EMPLOYEE7, EMPLOYEE8, EMPLOYEE9, EMPLOYEE10));

    public static final Map<Integer, List<Employee>> CONSTANT_MAP_OF_EMPLOYEE = new HashMap<>(
            CONSTANT_LIST_OF_EMPLOYEE
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getNumOfDepartment))
    );

    public static final Map<Integer, List<Employee>> CONSTANT_MAP_OF_EMPLOYEE_BY_DEP = new HashMap<>(
            CONSTANT_LIST_OF_EMPLOYEE
                    .stream()
                    .filter(e -> e.getNumOfDepartment().equals(1))
                    .collect(Collectors.groupingBy(Employee::getNumOfDepartment))
    );
}
