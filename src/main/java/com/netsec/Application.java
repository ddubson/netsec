package com.netsec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

/**
 * Author: ddubson
 */
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("good bye")));
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n#### Network Analyzer ####");
        while (true) {
            System.out.print("> ");
            String cmd = scanner.nextLine();

            CommandFactory.getCommand(cmd).exec();
        }
    }
}
