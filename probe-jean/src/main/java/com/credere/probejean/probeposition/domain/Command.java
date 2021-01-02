package com.credere.probejean.probeposition.domain;

public enum Command {

    GE("girar 90 graus à esquerda") {
        @Override
        public void exec(ProbePosition probePosition) {
            probePosition.getDirection().turnLeft(probePosition);
        }
    },

    GD("girar 90 graus à direita") {
        @Override
        public void exec(ProbePosition probePosition) {
            probePosition.getDirection().turnRight(probePosition);
        }
    },

    M("movimentar") {
        @Override
        public void exec(ProbePosition probePosition) {
            probePosition.getDirection().move(probePosition);
        }
    };

    public abstract void exec(ProbePosition probePosition);

    private String description;

    Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
