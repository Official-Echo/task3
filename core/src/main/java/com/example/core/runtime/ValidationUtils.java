package com.example.core.runtime;

import com.example.core.annotations.ValidateNotEmpty;

import java.lang.reflect.Field;

public class ValidationUtils {

	public static void validateObject(Object obj) throws IllegalAccessException {
		Class<?> runtime_class = obj.getClass();

		for (Field field : runtime_class.getDeclaredFields()) {
			if (field.isAnnotationPresent(ValidateNotEmpty.class)) {
				field.setAccessible(true);
				Object value = field.get(obj);

				ValidateNotEmpty annotation = field.getAnnotation(ValidateNotEmpty.class);

				if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
					throw new IllegalArgumentException(annotation.message() + " (Field: " + field.getName() + ")");
				}
			}
		}
	}

	public static void validateParameters(Object[] args, java.lang.reflect.Parameter[] parameters) {
		for (int i = 0; i < parameters.length; i++) {
			if (parameters[i].isAnnotationPresent(ValidateNotEmpty.class)) {
				ValidateNotEmpty annotation = parameters[i].getAnnotation(ValidateNotEmpty.class);
				Object value = args[i];

				if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
					throw new IllegalArgumentException(
							annotation.message() + " (Parameter: " + parameters[i].getName() + ")");
				}
			}
		}
	}
}