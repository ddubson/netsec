package com.netsec.cli.command;

import java.io.PrintStream;

/**
 * Author: ddubson
 */
public class NoActionCommand implements Command {
    @Override
    public void exec(PrintStream printStream, String... args) {
        printStream.println("Command not found.");
    }

    @Override
    public String getName() {
        return Name.NO_ACTION;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
