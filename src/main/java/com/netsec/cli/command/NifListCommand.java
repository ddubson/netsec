package com.netsec.cli.command;

import com.netsec.core.network.LocalDeviceInfo;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.util.LinkLayerAddress;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;

import static com.netsec.cli.CLI.ANSI_BLUE;
import static com.netsec.cli.CLI.colorize;

/**
 * Author: ddubson
 */
public class NifListCommand extends CLICommand {
    private LocalDeviceInfo localDeviceInfo;

    public NifListCommand(PrintStream printStream, LocalDeviceInfo localDeviceInfo) {
        super(printStream);
        this.localDeviceInfo = localDeviceInfo;
    }

    @Override
    public void exec(List<String> args) {
        printStream.println("Network Interfaces on Device:");
        List<PcapNetworkInterface> nifs = localDeviceInfo.getLocalInterfaces();
        nifs.sort(Comparator.comparing(PcapNetworkInterface::getName));
        for (PcapNetworkInterface nif : nifs) {
            printStream.format("%-20s", colorize(nif.getName(), ANSI_BLUE));
            printStream.print(
                    (nif.getDescription() != null && !nif.getDescription().isEmpty()
                            ? " [" + nif.getDescription() + "]" : ""));
            if (!nif.getLinkLayerAddresses().isEmpty()) {
                printStream.format("%s", "| MAC(s): ");
                for (LinkLayerAddress addr : nif.getLinkLayerAddresses()) {
                    printStream.print(addr.toString() + " ");
                }
            }
            printStream.println();
        }
        printStream.println();
    }

    @Override
    public String getName() {
        return Name.LIST_NIFS;
    }

    @Override
    public String getDescription() {
        return "Lists all network interfaces on the current device.";
    }
}
