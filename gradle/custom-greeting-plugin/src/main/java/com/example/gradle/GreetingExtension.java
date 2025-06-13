package com.example.gradle;

import org.gradle.api.provider.Property;

public abstract class GreetingExtension {
    public abstract Property<String> getMessage();
}