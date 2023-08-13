package skypro.course2.employeeBook.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.course2.employeeBook.exception.*;
import skypro.course2.employeeBook.model.Employee;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    private final List<Employee> expected = new ArrayList<>(List.of(
            new Employee(1, "Semen", "Semenov", 179369)));

    @BeforeEach
    public void setUp() {
        out.addEmployee(1, "Semen", "Semenov", 179369);
    }

    // проверяет добавился ли сотрудник
    @Test
    public void shouldAddEmployee() {
        assertEquals(expected, out.showEmployeeList());
        assertTrue(out.showEmployeeList().contains(new Employee(1, "Semen",
                "Semenov", 179369)));
        assertEquals(1, out.showEmployeeList().size());
    }

    //выбрасывается ли исключение, если добавляемый сотрудник уже есть в списке
    @Test
    public void shouldThrowExceptionIfEmployeeAlreadyAdded() {
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(1, "Semen", "Semenov", 179369));
    }

    //выбрасывается ли исключение, если задан некорректный номер отдела
    @Test
    public void shouldThrowExceptionIfSetIncorrectNumOfDep() {
        assertThrows(DepCountException.class,
                () -> out.addEmployee(out.getDEP_COUNT() + 1, "Semen", "Semenov", 179369));
        assertThrows(DepCountException.class,
                () -> out.addEmployee(0, "Semen", "Semenov", 179369));
    }

    // выбрасывается ли исключение, если превышено максимально возможное количество сотрудников
    //(для наполнения списка до предельного значения имя сотрудников было пропущено через StringBuilder,
    // чтобы избежать наполнения одинаковыми сотрудниками)
    @Test
    public void shouldThrowExceptionIfAdditionEmployeeExceedLimit() {
        StringBuilder stringBuilder = new StringBuilder("Semen");
        for (int i = 1; i < out.getMAX_COUNT_OF_EMPLOYEES(); i++) {
            stringBuilder.append("n");
            out.addEmployee(1, stringBuilder.toString(), "Semen", 179369);
        }
        assertThrows(EmployeeStorageIsFullException.class,
                () -> out.addEmployee(1, "Ivan", "Ivanov", 179369));
    }

    //выбрасывается ли исключение, если имя или фамилия сотрудника задано некорректно во время добавления
    @Test
    public void shouldThrowExceptionNameOrSurnameIsIncorrectWhileAdding() {
        assertThrows(WrongSymbolInputException.class,
                () -> out.addEmployee(1, "Semen+", "Semenov", 179369));
        assertThrows(WrongSymbolInputException.class,
                () -> out.addEmployee(1, "Semen", "Semenov+", 179369));
    }

    //проверяет удаляется ли сотрудник
    @Test
    public void shouldRemoveEmployee() {
        expected.remove(0);
        out.removeEmployee("Semen", "Semenov");
        assertEquals(expected, out.showEmployeeList());
        assertEquals(0, out.showEmployeeList().size());
    }

    //выбрасывается ли исключение, если удаляемый сотрудник не найден в списке
    @Test
    public void shouldThrowExceptionIfDeletedEmployeeIsNotFoundInList() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee("Ivan", "Ivanov"));
    }

    //выбрасывается ли исключение, если имя или фамилия сотрудника задано некорректно во время удаления
    @Test
    public void shouldThrowExceptionNameOrSurnameIsIncorrectWhileRemoving() {
        assertThrows(WrongSymbolInputException.class,
                () -> out.removeEmployee("Semen+", "Semenov"));
        assertThrows(WrongSymbolInputException.class,
                () -> out.removeEmployee("Semen", "Semenov+"));
    }

    //проверяет, находится ли сотрудник
    @Test
    public void shouldFindEmployee() {
        assertEquals(expected.get(0), out.findEmployee("Semen", "Semenov"));
    }

    //выбрасывается ли исключение, если сотрудник не найден в списке
    @Test
    public void shouldThrowExceptionIfEmployeeIsNotFoundInList() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee("Ivan", "Ivanov"));
    }

    //возвращается ли список всех сотрудников
    @Test
    public void shouldGetListOfAllEmployees() {
        assertEquals(expected, out.showEmployeeList());
    }
}
