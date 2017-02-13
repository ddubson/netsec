package com.netsec.cli;

import com.netsec.command.CommandFactory;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: ddubson
 */
public class CLI implements CommandLineRunner {
    private final CommandFactory commandFactory;
    private final String appBanner;

    public CLI(CommandFactory commandFactory, String appBanner) {
        this.commandFactory = commandFactory;
        this.appBanner = appBanner;
    }

    public void run(String... args) throws Exception {
        System.out.println(appBanner);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String cmd = scanner.nextLine();
            List<String> cmdArgs = new ArrayList<>();
            if(cmd.contains(" ")) {
                String[] ls = cmd.split(" ");
                cmd = ls[0];
                cmdArgs = Arrays.asList(ArrayUtils.subarray(ls, 1, ls.length));
            }

            commandFactory.getCommand(cmd).exec(cmdArgs.toArray(new String[0]));
        }
    }
}
