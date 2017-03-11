package com.netsec.cli.command;

import com.netsec.core.network.ArpQuery;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by ddubson on 3/5/17.
 */
public class ArpQueryCommand extends CLICommand {
    private ArpQuery arpQuery;

    public ArpQueryCommand(PrintStream printStream, ArpQuery arpQuery) {
        super(printStream);
        this.arpQuery = arpQuery;
    }

    @Override
    public void exec(List<String> args) {
        // TODO to implement
    }

    @Override
    public String getName() {
        return "arp";
    }

    @Override
    public String getDescription() {
        return "Queries the destination host for its MAC address in the ARP table.";
    }
}
