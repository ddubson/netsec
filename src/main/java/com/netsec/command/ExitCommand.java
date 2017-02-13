package com.netsec.command;

/**
 * Author: ddubson
 */
public class ExitCommand implements Command {
    @Override
    public void exec(String... args) {
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
