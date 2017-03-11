package com.netsec.cli;

import com.netsec.cli.command.Command;
import com.netsec.cli.command.CommandPublisher;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.CommandLineRunner;

import java.io.InputStream;
import java.io.PrintStream;
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

    private final CommandPublisher commandPublisher;
    private final String appBanner;
    private final PrintStream printStream;
    private final Scanner inputReader;

    public CLI(CommandPublisher commandPublisher, String appBanner, PrintStream printStream, Scanner inputReader) {
        this.commandPublisher = commandPublisher;
        this.appBanner = appBanner;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void run(String... args) throws Exception {
        printStream.println(appBanner);
        commandPublisher.publish(Command.Name.HELP);

        printCLILinePrefix();
        commandPublisher.publish(readInputAndSplitIntoArgs());
    }

    private String[] readInputAndSplitIntoArgs() {
        return inputReader.nextLine().split(" ");
    }

    private void printCLILinePrefix() {
        printStream.print("> ");
    }

    public static String colorize(String s, String AnsiColor) {
        return AnsiColor + s + ANSI_RESET;
    }
}
