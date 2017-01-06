package com.netsec;

/**
 * Author: ddubson
 */
public class NoActionCommand implements Command {
    @Override
    public void exec(String... args) {
        System.out.println("Command not found.");
    }
}
