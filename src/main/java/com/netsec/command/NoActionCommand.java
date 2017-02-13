package com.netsec.command;

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
}
