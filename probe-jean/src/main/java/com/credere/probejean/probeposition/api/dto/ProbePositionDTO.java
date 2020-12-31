package com.credere.probejean.probeposition.api.dto;

import com.credere.probejean.probeposition.domain.Directon;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProbePositionDTO {

    private Integer x;
    private Integer y;
    private Directon direction;

}
