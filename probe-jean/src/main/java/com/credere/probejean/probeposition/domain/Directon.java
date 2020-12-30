package com.credere.probejean.probeposition.domain;

public enum Directon {

    E("esquerda"),
    D("direita"),
    C("cima"),
    B("baixo");

    private String description;

    Directon(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
