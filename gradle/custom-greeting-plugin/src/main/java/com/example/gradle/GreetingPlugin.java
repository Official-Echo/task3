package main.java.com.example.gradle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.gradle.api.DefaultTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public abstract class GreetingExtension {
    public abstract Property<String> getMessage();
}

public abstract class GenerateGreetingTask extends DefaultTask {
    @Input
    public abstract Property<String> getGreetingMessage();

    @TaskAction
    public void generate() throws IOException {
        File outputDir = new File(getProject().getBuildDir(), "greetings");
        outputDir.mkdirs();
        File outputFile = new File(outputDir, "greeting.txt");
        Files.writeString(outputFile.toPath(), getGreetingMessage().get() + " from " + getProject().getName());
        System.out.println("Generated greeting file at: " + outputFile);
    }
}

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