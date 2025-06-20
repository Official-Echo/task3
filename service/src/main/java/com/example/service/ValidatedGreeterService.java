package com.example.service;

import com.example.core.Greeting;
import com.example.core.Person;
import com.example.core.annotations.LogExecution;
import com.example.core.annotations.ValidateNotEmpty;
import com.example.core.runtime.LoggingAspect;
import com.example.core.runtime.ValidationUtils;

import java.lang.reflect.Method;

public class ValidatedGreeterService extends GreeterService {

	@Override
	@LogExecution(value = "Creating validated greeting", logParameters = true)
	public Greeting createGreeting(@ValidateNotEmpty String name) {
		try {
			Method method = this.getClass().getMethod("createGreeting", String.class);

			ValidationUtils.validateParameters(new Object[] { name }, method.getParameters());

			Greeting result = super.createGreeting(name);

			LoggingAspect.logMethodExecution(method, new Object[] { name }, result);

			return result;
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("Method not found", e);
		}
	}

	@LogExecution("Creating person with validation")
	public Person createValidatedPerson(String name, String email, int age) {
		try {
			Method method = this.getClass().getMethod("createValidatedPerson", String.class, String.class, int.class);

			Person person = new Person(name, email, age);

			ValidationUtils.validateObject(person);

			LoggingAspect.logMethodExecution(method, new Object[] { name, email, age }, person);

			return person;
		} catch (Exception e) {
			System.err.println("[ERROR] Validation failed: " + e.getMessage());
			throw new RuntimeException("Person creation failed", e);
		}
	}
}