package com.netsec.cli.command;

import com.netsec.core.network.LocalDeviceInfo;
import org.pcap4j.core.PcapAddress;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.util.LinkLayerAddress;

import java.net.Inet4Address;
import java.net.Inet6Address;

/**
 * Author: ddubson
 */
public class DescribeNifCommand implements Command {
    private LocalDeviceInfo localDeviceInfo;

    public DescribeNifCommand(LocalDeviceInfo localDeviceInfo) {
        this.localDeviceInfo = localDeviceInfo;
    }

    @Override
    public void exec(String... args) {
        if (args.length == 0) {
            System.out.println("Network interface not specified.");
        }

        if (!localDeviceInfo.deviceExists(args[0])) {
            System.out.println("Network interface '" + args[0] + "' does not exist.");
        }

        PcapNetworkInterface nif = localDeviceInfo.getLocalInterfaceInfo(args[0]);
        System.out.println("Network Interface '" + nif.getName() + "':");
        System.out.println("\tDescription: " + nif.getDescription());
        System.out.println("\tLink Layer Addr: ");
        for (LinkLayerAddress addr : nif.getLinkLayerAddresses()) {
            System.out.println("\t\t[" + addr.toString() + "]");
        }
        System.out.println("\tNetwork Layer Addr: ");
        for (PcapAddress addr : nif.getAddresses()) {
            System.out.println("\t\t" + determineIPversion(addr) + ": " + addr.getAddress() + "");
        }
    }

    @Override
    public String getName() {
        return Name.DESCRIBE_NIF;
    }

    @Override
    public String getDescription() {
        return "Describe specified device interface.";
    }

    private String determineIPversion(PcapAddress addr) {
        if (addr.getAddress() instanceof Inet4Address) {
            return "IPv4";
        } else if (addr.getAddress() instanceof Inet6Address) {
            return "IPv6";
        } else {
            return "N/A";
        }
    }
}