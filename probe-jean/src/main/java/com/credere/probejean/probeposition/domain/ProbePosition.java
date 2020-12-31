package com.credere.probejean.probeposition.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "probePosition")
@Builder
@Getter
@Setter
public class ProbePosition {

    @Id
    private String id;

    private int x;
    private int y;
    private Directon direction;

}
