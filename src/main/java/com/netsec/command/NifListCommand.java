package com.netsec.command;

import com.netsec.network.LocalDeviceInfo;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.util.LinkLayerAddress;

import java.util.Comparator;
import java.util.List;

import static com.netsec.cli.CLI.ANSI_BLUE;
import static com.netsec.cli.CLI.colorize;

/**
 * Author: ddubson
 */
public class NifListCommand implements Command {
    private LocalDeviceInfo localDeviceInfo;

    public NifListCommand(LocalDeviceInfo localDeviceInfo) {
        this.localDeviceInfo = localDeviceInfo;
    }

    @Override
    public void exec(String... args) {
        System.out.println("Network Interfaces on Device:");
        List<PcapNetworkInterface> nifs = localDeviceInfo.getLocalInterfaces();
        nifs.sort(Comparator.comparing(PcapNetworkInterface::getName));
        for (PcapNetworkInterface nif : nifs) {
            System.out.format("%-20s", colorize(nif.getName(), ANSI_BLUE));
            System.out.print(
                    (nif.getDescription() != null && !nif.getDescription().isEmpty()
                            ? " [" + nif.getDescription() + "]" : ""));
            if (!nif.getLinkLayerAddresses().isEmpty()) {
                System.out.format("%s", "| MAC(s): ");
                for (LinkLayerAddress addr : nif.getLinkLayerAddresses()) {
                    System.out.print(addr.toString() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
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
