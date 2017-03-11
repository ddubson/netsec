package com.netsec.cli.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoActionCommandTest {
    @Mock
    PrintStream printStream;

    Command noActionCommand;

    @Before
    public void setUp() throws Exception {
        noActionCommand = new NoActionCommand(printStream);
    }

    @Test
    public void noActionCommandShouldPrintCommandNotFoundMsg() {
        noActionCommand.exec(asList("no-arg"));
        verify(printStream).println("Command not found.");
    }

    @Test
    public void noActionCommandShallNotImposeAnyArgRequirements() throws Exception {
        noActionCommand.exec(Collections.emptyList());
        verify(printStream).println("Command not found.");
    }
}