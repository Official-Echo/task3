package com.example.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test void appHasAGreeting() {
        assertDoesNotThrow(() -> {
            Main.main(new String[]{});
        });
    }
}