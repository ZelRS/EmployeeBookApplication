package skypro.course2.employeeBook.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.course2.employeeBook.exception.DepCountException;
import skypro.course2.employeeBook.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static skypro.course2.employeeBook.constants.DepartmentServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp() {
        when(employeeServiceMock.showEmployeeList()).thenReturn(CONSTANT_LIST_OF_EMPLOYEE);
    }

    //проверяет, возвращается ли сотрудник с максимальной зарплатой в отделе и выбрасывается ли исключение,
    // если номер оттедла задан некорректно
    @Test
    public void shouldGetEmployeeWithMaxSalaryOfDepOrThrowIfNumOfDepIncorrect() {
        assertEquals(EMPLOYEE1, out.getEmployeeWithMaxSalaryOfDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeeWithMaxSalaryOfDep(0));
    }

    //проверяет, возвращается ли сотрудник с минимальной зарплатой в отделе и выбрасывается ли исключение,
    // если номер оттедла задан некорректно
    @Test
    public void shouldGetEmployeeWithMinSalaryOfDepOrThrowIfNumOfDepIncorrect() {
        assertEquals(EMPLOYEE2, out.getEmployeeWithMinSalaryOfDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeeWithMinSalaryOfDep(0));
    }

    //проверяет, возвращается ли список сотрудников конкретного отдела и выбрасывается ли исключение,
    // если номер оттедла задан некорректно
    @Test
    public void shouldGetEmployeesListByDepOrThrowIfNumOfDepIncorrect() {
        assertEquals(CONSTANT_MAP_OF_EMPLOYEE_BY_DEP, out.getEmployeesListByDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeesListByDep(0));
    }

    //проверяет, возвращается ли список всех сотрудников с разделением по отделам
    @Test
    public void shouldGetAllEmployeesList() {
        assertEquals(CONSTANT_MAP_OF_EMPLOYEE, out.getAllEmployeesList());
    }

    //проверяет, возвращается ли сумма всех зарплат в отделе и выбрасывается ли исключение,
    // если номер оттедла задан некорректно
    @Test
    public void shouldGetSumOfSalaryByDepOrThrowIfNumOfDepIncorrect() {
        int expectedSum = EMPLOYEE1.getSalary() + EMPLOYEE2.getSalary();
        assertEquals(expectedSum, out.getSumOfSalaryByDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeesListByDep(0));
    }

}
