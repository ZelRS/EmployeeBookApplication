package skypro.course2.employeeBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongSymbolInputException extends RuntimeException {
    public WrongSymbolInputException(String message) {
        super(message);
    }

    public WrongSymbolInputException() {
    }
}
