package br.unisul;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.unisul.controller.GeradorDeSprite;
import br.unisul.model.Missil;
import br.unisul.model.Personagem;

public class GeradorDeSpriteTest {

    @Test
    public void deveriaSerFazendeiro() {
        Personagem fazendeiro = (Personagem) GeradorDeSprite.newSprite(0);
        assertEquals(100, fazendeiro.getEnergia());
        assertEquals(1, fazendeiro.getPosicao().getX());
        assertEquals(1, fazendeiro.getPosicao().getY());
    }

    @Test
    public void deveriaSerVaca() {
        Personagem vaca = (Personagem) GeradorDeSprite.newSprite(1);
        assertEquals(150, vaca.getEnergia());
    }

    @Test
    public void deveriaSerNave() {
        Personagem nave = (Personagem) GeradorDeSprite.newSprite(2);
        assertEquals(100, nave.getEnergia());
    }

    @Test
    public void deveriaSerMissil() {
        Missil missil = (Missil) GeradorDeSprite.newSprite(3);
        assertEquals(1, missil.getVelocidade());
        assertEquals(50, missil.getDano());
    }
}
