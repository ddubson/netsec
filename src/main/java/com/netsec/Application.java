package com.netsec;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: ddubson
 */
public class Application implements CommandLineRunner {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("good bye")));
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_GREEN + "\n#### Network Analyzer ####" + ANSI_RESET);
        while (true) {
            System.out.print("> ");
            String cmd = scanner.nextLine();
            List<String> cmdArgs = new ArrayList<>();
            if(cmd.contains(" ")) {
                String[] ls = cmd.split(" ");
                cmd = ls[0];
                cmdArgs = Arrays.asList(ArrayUtils.subarray(ls, 1, ls.length));
            }

            CommandFactory.getCommand(cmd).exec(cmdArgs.toArray(new String[0]));
        }
    }
}
