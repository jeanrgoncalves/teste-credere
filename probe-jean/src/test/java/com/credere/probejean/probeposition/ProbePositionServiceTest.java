package com.credere.probejean.probeposition;

import com.credere.probejean.probeposition.domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ProbePositionServiceTest {

    @SpyBean
    private ProbePositionService service;

    @MockBean
    private ProbePositionRepository repository;

    @Before
    public void initMocks() {
        ProbePosition probePosition = ProbePosition.builder()
                .x(0)
                .y(0)
                .direction(Directon.D)
                .build();
        Mockito.when(repository.findAll()).thenReturn(List.of(probePosition));
    }

    @Test
    public void executeCommandsSuccess() {
        List<Command> commands = List.of(Command.M, Command.M, Command.GE, Command.M, Command.GD, Command.M, Command.M, Command.GE);

        ProbePosition returnedPosition = service.executeCommands(commands);
        Assert.assertEquals("4", returnedPosition.getX().toString());
        Assert.assertEquals("1", returnedPosition.getY().toString());
        Assert.assertEquals("C", returnedPosition.getDirection().toString());
    }

    @Test
    public void executeCommandsFail() {
        List<Command> commands = List.of(Command.M, Command.M, Command.GE, Command.M, Command.M, Command.M, Command.M);

        boolean exceptionThrowed = false;

        try {
            service.executeCommands(commands);
        } catch (IllegalArgumentException e) {
            exceptionThrowed = true;
        }

        Assert.assertTrue(exceptionThrowed);
    }

}
