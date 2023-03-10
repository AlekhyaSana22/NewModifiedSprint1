package com.multiplex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
	   @ExceptionHandler(value=UserNotFoundException.class)
	    public ResponseEntity<String> userNotFound(UserNotFoundException ex) {
	        return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
	    }
	   @ExceptionHandler(value=UserAlreadyExistsException.class)
	   public ResponseEntity<String> userAlreadyExists(UserAlreadyExistsException ex) {
		   return new ResponseEntity<>("User Already exists", HttpStatus.NOT_ACCEPTABLE);
	   }
	   @ExceptionHandler(value=MovieNotFoundException.class)
	   public ResponseEntity<String> movieNotFound(MovieNotFoundException ex) {
		   return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(value=InvalidAdminException.class)
		public ResponseEntity<String>  invalidAdminException(InvalidAdminException ex) {
			return new ResponseEntity<>("Invalid Admin",HttpStatus.NOT_FOUND);
		}
	  
	   @ExceptionHandler(value=HallNotFoundExcepiton.class)
	   public ResponseEntity<String> hallNotFound(HallNotFoundExcepiton ex) {
		   return new ResponseEntity<>("Hall not Found", HttpStatus.NOT_FOUND);
	   }
	   @ExceptionHandler(value=BookingNotFoundException.class)
	   public ResponseEntity<String> bookingNotFound(BookingNotFoundException ex) {
		   return new ResponseEntity<>("Booking not Found", HttpStatus.NOT_FOUND);
	   }
	   @ExceptionHandler(value=ShowNotFoundException.class)
	   public ResponseEntity<String> showNotFound(ShowNotFoundException ex) {
		   return new ResponseEntity<>("Show not Found", HttpStatus.NOT_FOUND);
	   }
}
