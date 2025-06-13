package com.example.service;

import com.example.core.Greeting;

public class GreeterService {
    public Greeting createGreeting(String name) {
        return new Greeting("Hello, " + name + "!");
    }
}