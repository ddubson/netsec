package com.netsec.cli.command;

import java.util.List;

/**
 * Author: ddubson
 */
public interface Command {
    void exec(List<String> args);

    boolean isResponsible(String cmdName);

    String getName();

    String getDescription();

    class Name {
        public static final String DESCRIBE_NIF = "describe";
        public static final String LIST_NIFS = "nifs";
        public static final String NO_ACTION = "no-action";
        public static final String HELP = "help";
        public static final String EXIT = "exit";
    }
}
