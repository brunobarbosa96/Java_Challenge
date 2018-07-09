package com.mlchallenge.api.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MlChallengeExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error> erros = createErrorList(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Error> createErrorList(BindingResult bindingResult) {
		List<Error> errors = new ArrayList<>();
		
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String errorMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String errorDescription = fieldError.toString();
			errors.add(new Error(errorMessage, errorDescription));
		}
			
		return errors;
	}
	
	public static class Error {
		
		private String errorMessage;
		private String errorDescription;
		
		public Error(String errorMessage, String errorDescription) {
			this.errorMessage = errorMessage;
			this.errorDescription = errorDescription;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public String getErrorDescription() {
			return errorDescription;
		}
		
	}
}
