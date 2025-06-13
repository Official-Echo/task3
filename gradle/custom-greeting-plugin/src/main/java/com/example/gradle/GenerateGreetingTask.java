package com.example.gradle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public abstract class GenerateGreetingTask extends DefaultTask {
	@Input
	public abstract Property<String> getGreetingMessage();

	@TaskAction
	public void generate() throws IOException {
		File outputDir = new File(getProject().getLayout().getBuildDirectory().getAsFile().get(), "greetings");

		if(!outputDir.exists()){
			outputDir.mkdirs();
		}

		File outputFile = new File(outputDir, "greeting.txt");
		Files.writeString(outputFile.toPath(), getGreetingMessage().get() + " from " + getProject().getName());
		System.out.println("Generated greeting file at: " + outputFile);
	}
}