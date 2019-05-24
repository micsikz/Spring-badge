package hu.flowacademy.badge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

//@ControllerAdvice
public class UserNotFoundException extends RuntimeException {

    /*@ResponseBody
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    */

    public UserNotFoundException (String username) {
        super("Could not find user: " + username);
    }
}
