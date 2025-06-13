plugins {
    `java-library`
    id("com.example.greeting")
}

configure<com.example.gradle.GreetingExtension> {
    getMessage().set("Welcome")
}