package br.unisul.model;

public class Missil extends Sprite {
    private int velocidade;
    private int dano;

    public Missil (int velocidade, int dano) {
        this.setVelocidade(velocidade);
        this.setDano(dano);
    }

    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }
}
