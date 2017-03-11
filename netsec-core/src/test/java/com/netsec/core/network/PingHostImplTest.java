package com.netsec.core.network;

import org.junit.Before;

/**
 * Created by ddubson on 2/26/17.
 */
public class PingHostImplTest extends AbstractPingHostTest {
    @Before
    public void setUp() {
        this.pingHost = new PingHostImpl();
    }
}
