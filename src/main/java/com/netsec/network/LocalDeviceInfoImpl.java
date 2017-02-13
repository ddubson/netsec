package com.netsec.network;

import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;

import java.util.Collections;
import java.util.List;

/**
 * Author: ddubson
 */
public class LocalDeviceInfoImpl implements LocalDeviceInfo {
    @Override
    public List<PcapNetworkInterface> getLocalInterfaces() {
        try {
            return Pcaps.findAllDevs();
        } catch (PcapNativeException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public PcapNetworkInterface getLocalInterfaceInfo(String devName) {
        try {
            return Pcaps.getDevByName(devName);
        } catch (PcapNativeException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching device info.");
        }
    }
}
