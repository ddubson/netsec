package com.netsec.cli;

import com.netsec.cli.command.*;
import com.netsec.core.network.ArpQuery;
import com.netsec.core.network.ArpQueryImpl;
import com.netsec.core.network.LocalDeviceInfo;
import com.netsec.core.network.LocalDeviceInfoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.netsec.cli.CLI.ANSI_GREEN;
import static com.netsec.cli.CLI.colorize;

@Configuration
@Profile("cli")
public class CLIConfig {
    @Bean
    public CommandLineRunner cli() {
        return new CLI(commandFactory(), appBanner(), printStream(), inputStream());
    }

    @Bean
    public CommandPublisher commandFactory() {
        CommandPublisher commandPublisher = new CommandPublisher();
        commandPublisher.addCommand(new NifListCommand(printStream(), localDeviceInfo()));
        commandPublisher.addCommand(new DescribeNifCommand(printStream(), localDeviceInfo()));
        commandPublisher.addCommand(new NoActionCommand(printStream()));
        commandPublisher.addCommand(new HelpCommand(printStream(),commandPublisher));
        commandPublisher.addCommand(new ArpQueryCommand(printStream(), arpQuery()));
        commandPublisher.addCommand(new ExitCommand(printStream()));
        return commandPublisher;
    }

    @Bean
    public ArpQuery arpQuery() {
        return new ArpQueryImpl();
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

    @Bean
    public Scanner inputStream() { return new Scanner(System.in); }
}
