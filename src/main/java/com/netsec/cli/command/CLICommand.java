package com.netsec.cli.command;

import java.io.PrintStream;

public abstract class CLICommand implements Command{
    protected PrintStream printStream;

    public CLICommand(PrintStream printStream) {
        this.printStream = printStream;
    }

    public boolean isResponsible(String cmdName) {
        return this.getName().equalsIgnoreCase(cmdName);
    }
}
