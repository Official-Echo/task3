package com.example.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE) // Compile-time processing
public @interface GenerateToString {
    String prefix() default "";
    boolean includeFieldNames() default true;
}