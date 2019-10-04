package com.miraclesoft.io.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.miraclesoft.io.model.ErrorDetails;

@ControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {
	  public RestExceptionHandler() {
	        super();
	    }

	    @ExceptionHandler(RecordNotFoundException.class)
	    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
	        return handleExceptionInternal(ex, "Record not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	    }

	    @ExceptionHandler(RecordIdMismatchException.class)
	    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
	        return handleExceptionInternal(ex, "Updated Id must be same", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	    }
	    
	    @Override
		  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		      HttpHeaders headers, HttpStatus status, WebRequest request) {
		    ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
		        ex.getBindingResult().toString());
		    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		  }
//	    @ExceptionHandler({
//	        EmployeeIdMismatchException.class,
//	        ConstraintViolationException.class,
//	        DataIntegrityViolationException.class
//	      })
//	      public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
//	          return handleExceptionInternal(ex, ex
//	            .getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//	      }

}
