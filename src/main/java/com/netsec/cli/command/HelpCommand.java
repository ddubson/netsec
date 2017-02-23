package com.netsec.cli.command;

import java.io.PrintStream;

import static com.netsec.cli.CLI.ANSI_RED;
import static com.netsec.cli.CLI.colorize;

/**
 * Author: ddubson
 */
public class HelpCommand implements Command {
    private CommandFactory commandFactory;

    public HelpCommand(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void exec(PrintStream printStream, String... args) {
        printStream.println("Commands:");

        commandFactory.getAllCommands().forEach(command -> {
            printStream.println("\t"+ colorize(command.getName(), ANSI_RED) + ": " + command.getDescription());
        });

        printStream.println();
    }

    @Override
    public String getName() {
        return Name.HELP;
    }

    @Override
    public String getDescription() {
        return "Help command.";
    }
}
