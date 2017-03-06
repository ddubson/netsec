package com.netsec.core.network;

import org.pcap4j.util.MacAddress;

/**
 * Created by ddubson on 3/5/17.
 */
public interface ArpQuery {
    MacAddress arp(String nif, String srcIpAddr, String dstIpAddress);
}
