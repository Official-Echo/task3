package com.example.service;

import main.java.com.example.core.Greeting;

public class GreeterService {
    public Greeting createGreeting(String name) {
        return new Greeting("Hello, " + name + "!");
    }
}