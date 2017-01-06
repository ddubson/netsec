package com.netsec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

/**
 * Author: ddubson
 */
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
    }
}
