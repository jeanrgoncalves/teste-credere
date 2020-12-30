package com.credere.probejean.probeposition.domain;

public enum Command {

    GE("girar 90 graus à esquerda"),
    GD("girar 90 graus à direita"),
    M("movimentar");

    private String description;

    Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
