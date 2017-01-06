package com.netsec;

/**
 * Author: ddubson
 */
public class CommandFactory {
    public static Command getCommand(String cmdName, String... args) {
        if(cmdName.equals("nifs")) return new NifListCommand();
        else if(cmdName.equals("exit")) return new ExitCommand();
        else return new NoActionCommand();
    }
}
