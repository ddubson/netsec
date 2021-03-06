package com.netsec.cli.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            return this.commands.get(Command.Name.NO_ACTION);
        }
    }

    public List<Command> getAllCommands() {
        return commands.values().stream().collect(Collectors.toList());
    }
}
