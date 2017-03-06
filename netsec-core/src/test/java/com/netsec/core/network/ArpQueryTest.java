package com.netsec.core.network;

import org.junit.Test;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.util.MacAddress;

/**
 * Created by ddubson on 3/5/17.
 */
public class ArpQueryTest {
    @Test
    public void arpTest() throws PcapNativeException {
        ArpQuery arpQuery = new ArpQueryImpl();
        PcapNetworkInterface pcapNetworkInterface = Pcaps.getDevByName("en0");
        pcapNetworkInterface.getLinkLayerAddresses().get(0);
        MacAddress macAddress = arpQuery.arp("en0", "192.168.1.122", "192.168.1.1");
        System.out.println("Resolved address: " + macAddress);
    }
}
