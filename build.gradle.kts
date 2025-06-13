allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "com.example.greeting")
}