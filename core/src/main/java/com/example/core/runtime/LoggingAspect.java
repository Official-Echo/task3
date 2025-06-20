package com.example.core.runtime;

import com.example.core.annotations.LogExecution;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingAspect {

	public static void logMethodExecution(Method method, Object[] args, Object result) {
		if (method.isAnnotationPresent(LogExecution.class)) {
			LogExecution annotation = method.getAnnotation(LogExecution.class);

			String logMessage = annotation.value().isEmpty()
					? "Executing method: " + method.getName()
					: annotation.value();

			System.out.println("[LOG] " + logMessage);

			if (annotation.logParameters() && args != null && args.length > 0) {
				System.out.println("[LOG] Parameters: " + Arrays.toString(args));
			}

			if (result != null) {
				System.out.println("[LOG] Result: " + result);
			}
		}
	}
}