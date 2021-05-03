package br.unisul.controller;

import br.unisul.model.Personagens;
import br.unisul.model.Missil;
import br.unisul.model.Sprite;

public class GeradorDeSprite {
    public static Sprite newSprite(int tipo) {
        switch (tipo) {
            case 0:
                return Personagens.Fazendeiro.criarPersonagem();

            case 1:
                return Personagens.Vaca.criarPersonagem();

            case 2:
                return Personagens.Nave.criarPersonagem();

            case 3:
                return new Missil(1, 50);
            
            default:
                return null;
        }
    }
}
