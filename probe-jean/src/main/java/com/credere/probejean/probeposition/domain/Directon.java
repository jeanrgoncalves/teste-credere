package com.credere.probejean.probeposition.domain;

public enum Directon {

    E("esquerda") {
        @Override
        public void turnLeft(ProbePosition probePosition) {
            probePosition.setDirection(B);
        }

        public void turnRight(ProbePosition probePosition) {
            probePosition.setDirection(C);
        }

        public void move(ProbePosition probePosition) {
            probePosition.setX(probePosition.getX() - 1);
        }
    },

    D("direita") {
        public void turnLeft(ProbePosition probePosition) {
            probePosition.setDirection(C);
        }

        public void turnRight(ProbePosition probePosition) {
            probePosition.setDirection(B);
        }

        public void move(ProbePosition probePosition) {
            probePosition.setX(probePosition.getX() + 1);
        }
    },

    C("cima") {
        public void turnLeft(ProbePosition probePosition) {
            probePosition.setDirection(E);
        }

        public void turnRight(ProbePosition probePosition) {
            probePosition.setDirection(D);
        }

        public void move(ProbePosition probePosition) {
            probePosition.setY(probePosition.getY() + 1);
        }
    },

    B("baixo") {
        public void turnLeft(ProbePosition probePosition) {
            probePosition.setDirection(E);
        }

        public void turnRight(ProbePosition probePosition) {
            probePosition.setDirection(D);
        }

        public void move(ProbePosition probePosition) {
            probePosition.setY(probePosition.getY() - 1);
        }
    };

    public abstract void turnLeft(ProbePosition probePosition);
    public abstract void turnRight(ProbePosition probePosition);
    public abstract void move(ProbePosition probePosition);

    private String description;

    Directon(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
