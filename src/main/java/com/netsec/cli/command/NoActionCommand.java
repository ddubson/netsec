package com.netsec.cli.command;

/**
 * Author: ddubson
 */
public class NoActionCommand implements Command {
    @Override
    public void exec(String... args) {
        System.out.println("Command not found.");
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
