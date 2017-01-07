package com.netsec;

import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.util.LinkLayerAddress;

import java.util.Comparator;
import java.util.List;

/**
 * Author: ddubson
 */
public class NifListCommand implements Command {
    @Override
    public void exec(String... args) {
        System.out.println("Network Interfaces on Device:");
        try {
            List<PcapNetworkInterface> nifs = Pcaps.findAllDevs();
            nifs.sort(Comparator.comparing(PcapNetworkInterface::getName));
            for (PcapNetworkInterface nif : nifs) {
                System.out.format("%-10s", nif.getName());
                System.out.print(
                        (nif.getDescription() != null && !nif.getDescription().isEmpty()
                                ? " [" + nif.getDescription() + "]" : ""));
                if (!nif.getLinkLayerAddresses().isEmpty()) {
                    System.out.format("%s",  "| MAC(s): ");
                    for(LinkLayerAddress addr : nif.getLinkLayerAddresses()) {
                        System.out.print(addr.toString()+ " ");
                    }
                }
                System.out.println();
            }
        } catch (PcapNativeException e) {
            e.printStackTrace();
        }
    }
}
