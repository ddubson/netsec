package com.netsec.cli;

import com.netsec.cli.command.Command;
import com.netsec.cli.command.CommandPublisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CLITest {
    private InputStream originalStream;
    private String appBanner;
    private CommandPublisher commandPublisher;
    private CLI cli;

    @Before
    public void setUp() throws Exception {
        originalStream = System.in;
        appBanner = "Network Analyzer";
        this.commandPublisher = mock(CommandPublisher.class);
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(originalStream);
    }

    @Test
    public void CLIShallDisplayAppBannerAtLoad() throws Exception {
        System.setIn(new ByteArrayInputStream("exit".getBytes(Charset.defaultCharset())));
        Scanner inputReader = new Scanner(System.in);
        PrintStream printStream = mock(PrintStream.class);
        CLI cli = new CLI(commandPublisher, appBanner, printStream, inputReader);

        cli.run("arg");

        verify(printStream).println(appBanner);
    }

    @Test
    public void CLIShallPublishHelpCommandInitially() throws Exception {
        System.setIn(new ByteArrayInputStream("exit".getBytes(Charset.defaultCharset())));
        Scanner inputReader = new Scanner(System.in);
        PrintStream printStream = mock(PrintStream.class);
        CLI cli = new CLI(commandPublisher, appBanner, printStream, inputReader);

        cli.run("arg");
        verify(commandPublisher).publish(Command.Name.HELP);
    }
}