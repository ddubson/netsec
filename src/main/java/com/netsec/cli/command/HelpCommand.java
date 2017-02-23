package com.netsec.cli.command;

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
    public void exec(String... args) {
        System.out.println("Commands:");

        commandFactory.getAllCommands().forEach(command -> {
            System.out.println("\t"+ colorize(command.getName(), ANSI_RED) + ": " + command.getDescription());
        });

        System.out.println();
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
