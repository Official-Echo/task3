dependencies {
    implementation(project(":core"))
}

configure<com.example.gradle.GreetingExtension> {
    message.set("Greetings")
}