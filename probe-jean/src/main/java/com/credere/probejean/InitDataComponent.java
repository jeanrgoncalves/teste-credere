package com.credere.probejean;

import com.credere.probejean.probeposition.domain.Directon;
import com.credere.probejean.probeposition.domain.ProbePosition;
import com.credere.probejean.probeposition.domain.ProbePositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitDataComponent {

    @Autowired
    private ProbePositionRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        if (repository.findAll().isEmpty()) {
            ProbePosition probePosition = ProbePosition.builder()
                    .id(UUID.randomUUID().toString())
                    .x(2)
                    .y(3)
                    .direction(Directon.C)
                    .build();

            repository.save(probePosition);
        }
    }

}
