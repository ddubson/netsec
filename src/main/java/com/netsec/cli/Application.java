package com.netsec.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: ddubson
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        addShutdownHook();
        SpringApplication.run(Application.class, args);
    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("good bye")));
    }
}
