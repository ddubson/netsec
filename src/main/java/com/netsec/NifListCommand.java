package com.netsec;

import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;

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
            for(PcapNetworkInterface nif : nifs) {
                System.out.println("Interface " + nif.getName() +
                        (nif.getDescription() != null && !nif.getDescription().isEmpty()
                                ? " [" + nif.getDescription() + "]" : ""));
            }
        } catch (PcapNativeException e) {
            e.printStackTrace();
        }
    }
}
