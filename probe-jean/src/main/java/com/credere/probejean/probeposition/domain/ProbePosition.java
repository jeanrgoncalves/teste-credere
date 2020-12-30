package com.credere.probejean.probeposition.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "probePosition")
@Builder
@Getter
public class ProbePosition {

    private int x;
    private int y;
    private Directon direction;

}
