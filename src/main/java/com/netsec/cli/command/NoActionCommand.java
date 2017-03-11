package com.netsec.cli.command;

import java.io.PrintStream;
import java.util.List;

public class NoActionCommand extends CLICommand {
    public NoActionCommand(PrintStream printStream) {
        super(printStream);
    }

    @Override
    public void exec(List<String> args) {
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
