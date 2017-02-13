package com.netsec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ddubson
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public CommandFactory commandFactory() {
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.addCommand(new NifListCommand());
        commandFactory.addCommand(new DescribeNifCommand());
        commandFactory.addCommand(new NoActionCommand());
        commandFactory.addCommand(new ExitCommand());
        return commandFactory;
    }
}
