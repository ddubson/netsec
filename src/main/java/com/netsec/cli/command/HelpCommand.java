package com.netsec.cli.command;

import java.io.PrintStream;
import java.util.List;

import static com.netsec.cli.CLI.ANSI_RED;
import static com.netsec.cli.CLI.colorize;

/**
 * Author: ddubson
 */
public class HelpCommand extends CLICommand {
    private CommandPublisher commandPublisher;

    public HelpCommand(PrintStream printStream, CommandPublisher commandPublisher) {
        super(printStream);
        this.commandPublisher = commandPublisher;
    }

    @Override
    public void exec(List<String> args) {
        printStream.println("Commands:");

        commandPublisher.getAllCommands().forEach(command -> {
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
