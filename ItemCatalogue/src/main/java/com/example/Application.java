package com.example;

import io.micronaut.runtime.Micronaut;
import io.micronaut.context.env.Environment;

public class Application {
    public static void main(String[] args) {
        Micronaut.build(args)
                .mainClass(Application.class)
                .defaultEnvironments(Environment.DEVELOPMENT)
                .start();
    }
}