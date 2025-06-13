package com.example.app;

import com.example.service.GreeterService;

import com.example.core.Greeting;

public class Main {
    public static void main(String[] args) {
        GreeterService greeterService = new GreeterService();
        Greeting greeting = greeterService.createGreeting("World");
        System.out.println(greeting.getMessage());
    }
}