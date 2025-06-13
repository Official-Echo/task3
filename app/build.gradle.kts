plugins {
    application
    id("com.example.greeting")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":service"))
    testImplementation(libs.junit.jupiter)
}

application {
    mainClass.set("com.example.app.Main")
}

configure<com.example.gradle.GreetingExtension> {
    getMessage().set("Hi")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}