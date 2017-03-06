package com.netsec.core.network;

import org.pcap4j.packet.IcmpV4EchoReplyPacket;

/**
 * Created by ddubson on 2/26/17.
 */
public interface PingHost {
    IcmpV4EchoReplyPacket ping(String host);
}
