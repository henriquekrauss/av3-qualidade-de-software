package br.unisul.model;

public abstract class Sprite {
    private Coordenada posicao;

    public Sprite() {
        this.posicao = new Coordenada();
    }

    public Sprite(int x, int y) {
        this.posicao = new Coordenada();
        this.move(x, y);
    }

    public void move(int x, int y) {
        posicao.setX(x);
        posicao.setY(y);
    }

    public Coordenada getPosicao() {
        return posicao;
    }
}