package com.example.core;

import com.example.core.annotations.GenerateToString;
import com.example.core.annotations.ValidateNotEmpty;

@GenerateToString(prefix = "Greeting", includeFieldNames = true)
public class Greeting {
    @ValidateNotEmpty(message = "Greeting message cannot be empty")
    private final String message;

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}