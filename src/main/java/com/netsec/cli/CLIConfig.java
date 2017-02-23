package com.netsec.cli;

import com.netsec.cli.command.*;
import com.netsec.core.network.LocalDeviceInfo;
import com.netsec.core.network.LocalDeviceInfoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.PrintStream;

import static com.netsec.cli.CLI.ANSI_GREEN;
import static com.netsec.cli.CLI.colorize;

/**
 * Author: ddubson
 */
@Configuration
@Profile("cli")
public class CLIConfig {
    @Bean
    public CommandLineRunner cli() {
        return new CLI(commandFactory(), appBanner(), printStream());
    }

    @Bean
    public CommandFactory commandFactory() {
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.addCommand(new NifListCommand(localDeviceInfo()));
        commandFactory.addCommand(new DescribeNifCommand(localDeviceInfo()));
        commandFactory.addCommand(new NoActionCommand());
        commandFactory.addCommand(new HelpCommand(commandFactory));
        commandFactory.addCommand(new ExitCommand());
        return commandFactory;
    }

    @Bean
    public String appBanner() {
        return colorize("\n#### Network Analyzer ####", ANSI_GREEN);
    }

    @Bean
    public LocalDeviceInfo localDeviceInfo() {
        return new LocalDeviceInfoImpl();
    }

    @Bean
    public PrintStream printStream() {
        return System.out;
    }
}
