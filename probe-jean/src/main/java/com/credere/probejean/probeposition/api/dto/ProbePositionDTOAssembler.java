package com.credere.probejean.probeposition.api.dto;

import com.credere.probejean.probeposition.domain.ProbePosition;
import org.springframework.stereotype.Component;

@Component
public class ProbePositionDTOAssembler {

    public ProbePosition fromDTO(ProbePositionDTO dto) {
        return ProbePosition.builder()
                .x(dto.getX())
                .y(dto.getY())
                .direction(dto.getDirection())
                .build();
    }

    public ProbePositionDTO fromEntity(ProbePosition entity) {
        return ProbePositionDTO.builder()
                .x(entity.getX())
                .y(entity.getY())
                .direction(entity.getDirection())
                .build();
    }

}
