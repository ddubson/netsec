package com.netsec.cli.command;

import java.io.PrintStream;

/**
 * Author: ddubson
 */
public class ExitCommand implements Command {
    @Override
    public void exec(PrintStream printStream, String... args) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return Name.EXIT;
    }

    @Override
    public String getDescription() {
        return "Exit the application.";
    }
}
