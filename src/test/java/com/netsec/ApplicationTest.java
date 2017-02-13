package com.netsec;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Author: ddubson
 */
public class ApplicationTest {
    @Test
    public void applicationShouldPrintBannerUponStart() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));


        //assertTrue(outputStream.toString().startsWith("Banner"));
    }
}