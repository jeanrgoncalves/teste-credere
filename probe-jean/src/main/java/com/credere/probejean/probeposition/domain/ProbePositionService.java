package com.credere.probejean.probeposition.domain;

import com.credere.probejean.probeposition.Messages;
import com.credere.probejean.util.ShapeDimensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProbePositionService {

    @Autowired
    private ProbePositionRepository repository;

    public void reset() {
        repository.findAll().stream()
                .findFirst()
                .ifPresentOrElse(probePosition -> {
                    probePosition.setX(0);
                    probePosition.setY(0);
                    probePosition.setDirection(Directon.D);
                    repository.save(probePosition);
                }, () -> {
                    throw new NoSuchElementException(Messages.RECORD_NOT_FOUND);
                });
    }

    public ProbePosition executeCommands(List<Command> commands) {
        List<ProbePosition> positions = repository.findAll();
        if (!positions.isEmpty()) {
            return processCommands(positions.get(0), commands);
        } else {
            throw new NoSuchElementException(Messages.RECORD_NOT_FOUND);
        }
    }

    private ProbePosition processCommands(ProbePosition probePosition, List<Command> commands) {
        for(Command command : commands) {
            command.execute(probePosition);
        }

        if (validPosition(probePosition)) {
            repository.save(probePosition);
            return probePosition;
        } else {
            throw new IllegalArgumentException(Messages.INVALID_COMMANDS_SEQUENCE);
        }
    }

    private boolean validPosition(ProbePosition probePosition) {
        return (probePosition.getX() >= ShapeDimensions.MIN_X && probePosition.getX() <= ShapeDimensions.MAX_X) &&
                (probePosition.getY() >= ShapeDimensions.MIN_Y && probePosition.getY() <= ShapeDimensions.MAX_Y);
    }

    public ProbePosition get() {
        return repository.findAll().stream()
                .findFirst()
                .orElseGet(() -> ProbePosition.builder().build());
    }

}
