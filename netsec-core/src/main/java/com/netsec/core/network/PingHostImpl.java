package com.netsec.core.network;

import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.*;
import org.pcap4j.packet.namednumber.*;
import org.pcap4j.util.MacAddress;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ddubson on 2/26/17.
 */
public class PingHostImpl implements PingHost {
    private static final String READ_TIMEOUT_KEY
            = PingHostImpl.class.getName() + ".readTimeout";
    private static final int READ_TIMEOUT
            = Integer.getInteger(READ_TIMEOUT_KEY, 10); // [ms]

    private static final String SNAPLEN_KEY
            = PingHostImpl.class.getName() + ".snaplen";
    private static final int SNAPLEN
            = Integer.getInteger(SNAPLEN_KEY, 65536); // [bytes]

    private static final String TU_KEY
            = PingHostImpl.class.getName() + ".tu";
    private static final int TU
            = Integer.getInteger(TU_KEY, 4000); // [bytes]

    @Override
    public IcmpV4EchoReplyPacket ping(String host) {
        PcapNetworkInterface nif = null;
        try {
            nif = Pcaps.getDevByName("en0");
        } catch (PcapNativeException e) {
            e.printStackTrace();
            return null;
        }

        try {
            PcapHandle sendHandle
                    = nif.openLive(SNAPLEN, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, READ_TIMEOUT);
        } catch (PcapNativeException e) {
            e.printStackTrace();
            return null;
        }

        byte[] echoData = generateEchoData();

        IcmpV4EchoPacket.Builder echoBuilder = new IcmpV4EchoPacket.Builder();
        echoBuilder
                .identifier((short) 1)
                .payloadBuilder(new UnknownPacket.Builder().rawData(echoData));

        IcmpV4CommonPacket.Builder icmpV4CommonBuilder = new IcmpV4CommonPacket.Builder();
        icmpV4CommonBuilder
                .type(IcmpV4Type.ECHO)
                .code(IcmpV4Code.NO_CODE)
                .payloadBuilder(echoBuilder)
                .correctChecksumAtBuild(true);

        IpV4Packet.Builder ipV4Builder = new IpV4Packet.Builder();
        try {
            ipV4Builder
                    .version(IpVersion.IPV4)
                    .tos(IpV4Rfc791Tos.newInstance((byte) 0))
                    .ttl((byte) 100)
                    .protocol(IpNumber.ICMPV4)
                    .srcAddr((Inet4Address) InetAddress.getByName("127.0.0.1"))
                    .dstAddr((Inet4Address) InetAddress.getByName(host))
                    .payloadBuilder(icmpV4CommonBuilder)
                    .correctChecksumAtBuild(true)
                    .correctLengthAtBuild(true);
        } catch (UnknownHostException e1) {
            throw new IllegalArgumentException(e1);
        }

        /*EthernetPacket.Builder etherBuilder = new EthernetPacket.Builder();
        etherBuilder.dstAddr(MacAddress.getByName(strDstMacAddress, ":"))
                .srcAddr(srcMacAddr)
                .type(EtherType.IPV4)
                .paddingAtBuild(true);*/

        return null;
    }

    private byte[] generateEchoData() {
        byte[] echoData = new byte[TU - 28];
        for (int i = 0; i < echoData.length; i++) {
            echoData[i] = (byte) i;
        }
        return echoData;
    }
}
