package com.netsec.cli.command;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CommandPublisher {
    Set<Command> commands;

    public CommandPublisher() {
        this.commands = new HashSet<>();
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public List<Command> getAllCommands() {
        return commands.stream().collect(Collectors.toList());
    }

    public void publish(String... args) {
        this.commands.stream().filter(cmd -> cmd.isResponsible(args[0]))
                .forEach(cmd -> cmd.exec(asList(ArrayUtils.subarray(args, 1, args.length))));
    }
}
