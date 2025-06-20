package com.example.service;

import com.example.core.Greeting;
import com.example.core.annotations.LogExecution;
import com.example.core.annotations.ValidateNotEmpty;

public class GreeterService {
	@LogExecution(value = "Creating greeting", logParameters = true)
	public Greeting createGreeting(@ValidateNotEmpty String name) {
		return new Greeting("Hello, " + name + "!");
	}

	@LogExecution("Creating personalized greeting")
	public Greeting createPersonalizedGreeting(String name, String title) {
		if (title != null && !title.isEmpty()) {
			return new Greeting("Hello, " + title + " " + name + "!");
		}
		return createGreeting(name);
	}
}