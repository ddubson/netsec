package com.netsec;

import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.Pcaps;

/**
 * Author: ddubson
 */
public class NifListCommand implements Command {
    @Override
    public void exec(String... args) {
        System.out.println("Network Interfaces:");
        try {
            Pcaps.findAllDevs().stream().forEach(ifs -> {
                System.out.println(ifs.getName());
            });
        } catch (PcapNativeException e) {
            e.printStackTrace();
        }
    }
}
