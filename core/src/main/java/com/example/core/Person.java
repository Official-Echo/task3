package com.example.core;

import com.example.core.annotations.GenerateToString;
import com.example.core.annotations.ValidateNotEmpty;

@GenerateToString(prefix = "Person")
public class Person {
    @ValidateNotEmpty(message = "Name cannot be empty")
    private final String name;

    @ValidateNotEmpty(message = "Email cannot be empty")
    private final String email;

    private final int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}