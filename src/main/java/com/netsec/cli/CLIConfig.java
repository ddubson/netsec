package com.netsec.cli;

import com.netsec.command.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Author: ddubson
 */
@Configuration
@Profile("cli")
public class CLIConfig {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Bean
    public CommandLineRunner cli() {
        return new CLI(commandFactory(), appBanner());
    }

    @Bean
    public CommandFactory commandFactory() {
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.addCommand(new NifListCommand());
        commandFactory.addCommand(new DescribeNifCommand());
        commandFactory.addCommand(new NoActionCommand());
        commandFactory.addCommand(new ExitCommand());
        return commandFactory;
    }

    @Bean
    public String appBanner() {
        return ANSI_GREEN + "\n#### Network Analyzer ####" + ANSI_RESET;
    }
}
