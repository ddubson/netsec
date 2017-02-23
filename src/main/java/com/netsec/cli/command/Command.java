package com.netsec.cli.command;

/**
 * Author: ddubson
 */
public interface Command {
    void exec(String... args);

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
