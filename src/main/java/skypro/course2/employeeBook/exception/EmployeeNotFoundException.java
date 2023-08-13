package skypro.course2.employeeBook.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
    public EmployeeNotFoundException() {

    }
}

