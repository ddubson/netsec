package com.netsec.network;

import org.pcap4j.core.PcapNetworkInterface;

import java.util.List;

/**
 * Author: ddubson
 */
public interface LocalDeviceInfo {
    List<PcapNetworkInterface> getLocalInterfaces();

    PcapNetworkInterface getLocalInterfaceInfo(String devName);
}
