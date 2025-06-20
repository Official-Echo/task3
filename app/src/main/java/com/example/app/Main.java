package com.example.app;

import com.example.core.Greeting;
import com.example.core.Person;
import com.example.service.ValidatedGreeterService;

public class Main {
	public static void main(String[] args) {
		ValidatedGreeterService service = new ValidatedGreeterService();

		try {
			System.out.println("=== Testing Runtime Annotations ===");

			Greeting validGreeting = service.createGreeting("World");
			System.out.println("Valid greeting: " + validGreeting.getMessage());

			Person validPerson = service.createValidatedPerson("John Doe", "john@example.com", 30);
			System.out.println("Valid person created: " + validPerson.getName());

			System.out.println("\n=== Testing Validation ===");
			try {
				service.createGreeting("");
			} catch (Exception e) {
				System.out.println("Caught expected error: " + e.getMessage());
			}

			try {
				service.createValidatedPerson("Jane Doe", "", 25);
			} catch (Exception e) {
				System.out.println("Caught expected error: " + e.getMessage());
			}

		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}