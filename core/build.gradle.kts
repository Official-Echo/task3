plugins {
    `java-library`
    id("com.example.greeting")
}

java{
	sourceCompatibility = JavaVersion.VERSION_21
	targetCompatibility = JavaVersion.VERSION_21
}

configure<com.example.gradle.GreetingExtension> {
    getMessage().set("Welcome")
}

tasks.withType<JavaCompile> {
    options.annotationProcessorPath = configurations.compileClasspath.get()
}