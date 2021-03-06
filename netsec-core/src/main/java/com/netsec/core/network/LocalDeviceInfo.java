package com.netsec.core.network;

import org.pcap4j.core.PcapNetworkInterface;

import java.util.List;

/**
 * Author: ddubson
 */
public interface LocalDeviceInfo {
    List<PcapNetworkInterface> getLocalInterfaces();

    PcapNetworkInterface getLocalInterfaceInfo(String devName);

    boolean deviceExists(String devName);
}
