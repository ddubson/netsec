package com.netsec.cli.command;

import com.netsec.core.network.LocalDeviceInfo;
import org.pcap4j.core.PcapAddress;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.util.LinkLayerAddress;

import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.List;

public class DescribeNifCommand extends CLICommand {
    private LocalDeviceInfo localDeviceInfo;

    public DescribeNifCommand(PrintStream printStream, LocalDeviceInfo localDeviceInfo) {
        super(printStream);
        this.localDeviceInfo = localDeviceInfo;
    }

    @Override
    public void exec(List<String> args) {
        if (args == null || args.size() < 1) {
            printStream.println("Network interface not specified.");
            return;
        }

        if (!localDeviceInfo.deviceExists(args.get(0))) {
            printStream.println("Network interface '" + args.get(0) + "' does not exist.");
        }

        PcapNetworkInterface nif = localDeviceInfo.getLocalInterfaceInfo(args.get(0));
        printStream.println("Network Interface '" + nif.getName() + "':");
        printStream.println("\tDescription: " + nif.getDescription());
        printStream.println("\tLink Layer Addr: ");
        for (LinkLayerAddress addr : nif.getLinkLayerAddresses()) {
            printStream.println("\t\t[" + addr.toString() + "]");
        }
        printStream.println("\tNetwork Layer Addr: ");
        for (PcapAddress addr : nif.getAddresses()) {
            printStream.println("\t\t" + determineIPversion(addr) + ": " + addr.getAddress() + "");
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
