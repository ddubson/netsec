package com.netsec;

import org.pcap4j.core.Pcaps;
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

            if (cmd.equals("nifs")) {
                System.out.println("Network Interfaces:");
                Pcaps.findAllDevs().stream().forEach(ifs -> {
                    System.out.println(ifs.getName());
                });
            } else if (cmd.equals("exit")) {
                System.exit(0);
            }
        }
    }
}
