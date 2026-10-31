package com.norgini.infrastructure.adapters.in.web.handler;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.norgini.domain.exception.BusinessException;
import com.norgini.domain.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalHandlerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> handleResourceNotFound(ResourceNotFoundException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(
				Instant.now(), status.value(), "Recurso não encontrado", ex.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<StandardError> handleBusiness(BusinessException ex, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				Instant.now(), status.value(), "Regra de Negócio Violada",
				ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> handleValidation(MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_CONTENT;

		ValidationError err = new ValidationError(
				Instant.now(), status.value(), 
				"Erro de Validação de Dados",
				"Verifique os campos preenchidos", 
				request.getRequestURI());

		ex.getBindingResult().getFieldErrors()
				.forEach(
						fieldError -> err.addError(
						fieldError.getField(), 
						fieldError.getDefaultMessage()));

		return ResponseEntity.status(status).body(err);
	}

}
