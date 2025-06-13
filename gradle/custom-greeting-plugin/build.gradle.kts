plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
	mavenCentral()
	gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("greetingPlugin") {
            id = "com.example.greeting"
            implementationClass = "com.example.gradle.CustomGreetingPlugin"
        }
    }
}