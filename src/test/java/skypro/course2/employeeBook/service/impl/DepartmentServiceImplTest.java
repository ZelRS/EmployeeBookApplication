package skypro.course2.employeeBook.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.course2.employeeBook.exception.DepCountException;
import skypro.course2.employeeBook.model.Employee;
import skypro.course2.employeeBook.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
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
    //если номер оттедла задан некорректно, проверяет количество вызова метода showEmployeeList()
    @Test
    public void shouldGetEmployeeWithMaxSalaryOfDepOrThrowIfNumOfDepIncorrect() {
        assertEquals(EMPLOYEE1, out.getEmployeeWithMaxSalaryOfDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeeWithMaxSalaryOfDep(0));
        verify(employeeServiceMock, times(1)).showEmployeeList();
    }

    //проверяет, возвращается ли сотрудник с минимальной зарплатой в отделе и выбрасывается ли исключение,
    //если номер оттедла задан некорректно, проверяет количество вызова метода showEmployeeList()
    @Test
    public void shouldGetEmployeeWithMinSalaryOfDepOrThrowIfNumOfDepIncorrect() {
        assertEquals(EMPLOYEE2, out.getEmployeeWithMinSalaryOfDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeeWithMinSalaryOfDep(0));
        verify(employeeServiceMock, times(1)).showEmployeeList();
    }

    //проверяет, возвращается ли список сотрудников конкретного отдела и выбрасывается ли исключение,
    //если номер оттедла задан некорректно, проверяет количество вызова метода showEmployeeList()
    @Test
    public void shouldGetEmployeesListByDepOrThrowIfNumOfDepIncorrect() {
        assertEquals(CONSTANT_MAP_OF_EMPLOYEE_BY_DEP, out.getEmployeesListByDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeesListByDep(0));
        verify(employeeServiceMock, times(1)).showEmployeeList();
    }

    //проверяет, возвращается ли список всех сотрудников с разделением по отделам,
    //проверяет количество вызова метода showEmployeeList()
    @Test
    public void shouldGetAllEmployeesList() {
        assertEquals(CONSTANT_MAP_OF_EMPLOYEE, out.getAllEmployeesList());
        verify(employeeServiceMock, times(1)).showEmployeeList();
    }

    //проверяет, возвращается ли сумма всех зарплат в отделе и выбрасывается ли исключение,
    //если номер оттедла задан некорректно, проверяет количество вызова метода showEmployeeList()
    @Test
    public void shouldGetSumOfSalaryByDepOrThrowIfNumOfDepIncorrect() {
        int expected = CONSTANT_LIST_OF_EMPLOYEE.stream()
                .filter(e -> e.getNumOfDepartment().equals(1))
                .mapToInt(Employee::getSalary)
                .sum();
        assertEquals(expected, out.getSumOfSalaryByDep(1));
        assertThrows(DepCountException.class, () -> out.getEmployeesListByDep(0));
        verify(employeeServiceMock, times(1)).showEmployeeList();
    }

}
