package com.example.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CustomGreetingPlugin implements Plugin<Project> {
	@Override
	public void apply(Project project) {
		GreetingExtension extension = project.getExtensions().create("greeting", GreetingExtension.class);
		extension.getMessage().set("Hello");

		project.getTasks().register("generateGreeting", GenerateGreetingTask.class, task -> {
			task.getGreetingMessage().set(extension.getMessage());
			task.setDescription("Generates a greeting file for the project.");
			task.setGroup("Greeting");
		});

		project.getTasks().named("build").configure(task -> task.dependsOn("generateGreeting"));
	}
}