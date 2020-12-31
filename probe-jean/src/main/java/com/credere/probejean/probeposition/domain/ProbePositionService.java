package com.credere.probejean.probeposition.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    throw new NoSuchElementException("Não foi encontrado registro de posição da Sonda");
                });
    }

}
