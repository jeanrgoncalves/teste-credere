package com.credere.probejean.probeposition.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

@ApiModel
public enum Command {

    GE("girar 90 graus à esquerda") {
        @Override
        public void execute(ProbePosition probePosition) {
            probePosition.getDirection().turnLeft(probePosition);
        }
    },

    GD("girar 90 graus à direita") {
        @Override
        public void execute(ProbePosition probePosition) {
            probePosition.getDirection().turnRight(probePosition);
        }
    },

    M("movimentar") {
        @Override
        public void execute(ProbePosition probePosition) {
            probePosition.getDirection().move(probePosition);
        }
    };

    public abstract void execute(ProbePosition probePosition);

    private String description;

    Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
