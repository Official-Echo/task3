plugins {
    `java-library`
    id("com.example.greeting")
}

dependencies {
    implementation(project(":core"))
}

configure<com.example.gradle.GreetingExtension> {
    getMessage().set("Greetings")
}