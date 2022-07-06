package edu.miu.amp.exception;

import edu.miu.amp.exception.custom.ApiError;
import edu.miu.amp.exception.custom.MailSendException;
import edu.miu.amp.exception.custom.ResourceNotFoundException;
import edu.miu.amp.exception.custom.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final String INTERNAL_SERVER_ERROR = "Something went wrong!";

    @ExceptionHandler({UserNotFoundException.class, ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleUserNotFound(
            RuntimeException ex, WebRequest request) {
        logger.error(ex.getMessage());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), toPath(request));
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler({MailSendException.class})
    protected ResponseEntity<Object> handleMailSendError(
            RuntimeException ex, WebRequest request) {
        logger.error(ex.getMessage());
        ApiError apiError = new ApiError(HttpStatus.BAD_GATEWAY, ex.getMessage(), toPath(request));
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleExceptionHandler(Exception ex, WebRequest request) {
        logger.error(ex.getMessage());
        ex.printStackTrace();
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, toPath(request));
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    private String toPath(WebRequest webRequest){
        return ((ServletWebRequest)webRequest).getRequest().getRequestURL().toString();
    }

}