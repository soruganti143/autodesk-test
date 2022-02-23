package com.beta.replyservice.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@RestController
public class ReplyServiceExceptionHandler {
	@ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<ReplyServiveException> exception(ResponseStatusException exception) {
		return new ResponseEntity<>(new ReplyServiveException(exception.getStatus().value(), exception.getReason()),
				exception.getStatus());
	}

}
