dependencies {
    implementation(project(":core"))
    implementation(project(":service"))
}

application {
    mainClass.set("com.example.app.Main")
}

configure<com.example.gradle.GreetingExtension> {
    message.set("Hi")
}