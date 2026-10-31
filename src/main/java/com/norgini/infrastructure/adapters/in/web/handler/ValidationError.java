package com.norgini.infrastructure.adapters.in.web.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private final List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

	@Getter
	public static class FieldMessage {
		private final String fieldName;
		private final String message;

		public FieldMessage(String fieldName, String message) {
			this.fieldName = fieldName;
			this.message = message;
		}
	}
}
