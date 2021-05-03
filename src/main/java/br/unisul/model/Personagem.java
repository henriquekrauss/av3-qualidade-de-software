package br.unisul.model;

public class Personagem extends Sprite {
    private int energia;

    public Personagem(int energia) {
        this.setEnergia(energia);
    }

    public Personagem(int energia, int x, int y) {
        super(x, y);
        this.setEnergia(energia);
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}
