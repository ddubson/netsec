package com.netsec.core.network;

import org.junit.Test;
import org.pcap4j.packet.IcmpV4EchoPacket;
import org.pcap4j.packet.IcmpV4EchoReplyPacket;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddubson on 2/26/17.
 */
public abstract class AbstractPingHostTest {
    protected PingHost pingHost;

    @Test
    public void pingHost() {
        String host = "localhost";
        IcmpV4EchoReplyPacket pingReplyPacket = pingHost.ping(host);
        pingReplyPacket.getPayload();
        System.out.println();
    }
}
