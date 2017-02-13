package com.netsec;

import java.util.HashMap;
import java.util.Map;

import static com.netsec.Command.Name.NO_ACTION;

/**
 * Author: ddubson
 */
public class CommandFactory {
    private Map<String, Command> commands;

    public CommandFactory() {
        this.commands = new HashMap<>();
    }

    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    public Command getCommand(String cmdName, String... args) {
        if(this.commands.containsKey(cmdName)) {
            return this.commands.get(cmdName);
        } else {
            return this.commands.get(NO_ACTION);
        }
    }
}
