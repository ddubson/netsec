package com.netsec;

/**
 * Author: ddubson
 */
public class ExitCommand implements Command {
    @Override
    public void exec(String... args) {
        System.exit(0);
    }
}
