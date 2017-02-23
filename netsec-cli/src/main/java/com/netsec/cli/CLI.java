package com.netsec.cli;

import com.netsec.cli.command.Command;
import com.netsec.cli.command.CommandFactory;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: ddubson
 */
public class CLI implements CommandLineRunner {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private final CommandFactory commandFactory;
    private final String appBanner;

    public CLI(CommandFactory commandFactory, String appBanner) {
        this.commandFactory = commandFactory;
        this.appBanner = appBanner;
    }

    public void run(String... args) throws Exception {
        System.out.println(appBanner);
        commandFactory.getCommand(Command.Name.HELP).exec();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String cmd = scanner.nextLine();
            List<String> cmdArgs = new ArrayList<>();
            if(cmd.contains(" ")) {
                String[] ls = cmd.split(" ");
                cmd = ls[0];
                cmdArgs = Arrays.asList(ArrayUtils.subarray(ls, 1, ls.length));
            }

            commandFactory.getCommand(cmd).exec(cmdArgs.toArray(new String[0]));
        }
    }

    public static String colorize(String s, String AnsiColor) {
        return AnsiColor + s + ANSI_RESET;
    }
}
