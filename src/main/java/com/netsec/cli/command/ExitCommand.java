package com.netsec.cli.command;

import java.io.PrintStream;
import java.util.List;

/**
 * Author: ddubson
 */
public class ExitCommand extends CLICommand {
    private PrintStream printStream;

    public ExitCommand(PrintStream printStream) {
        super(printStream);
    }

    @Override
    public void exec(List<String> args) {
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
