package br.unisul.controller;

import java.util.Random;

import br.unisul.model.Personagem;
import br.unisul.model.Missil;
import br.unisul.model.Sprite;

public class Fase {
    private static int fase;
    private static int municao;
    private static int tentativaAtirar, tentativaEsquivar;
    private static Sprite personagens[] = new Sprite[4];

    public static void comecar() {
        fase = 1;
        municao = 3;
        personagens[0] = GeradorDeSprite.newSprite(0);
        personagens[1] = GeradorDeSprite.newSprite(1);
        personagens[2] = GeradorDeSprite.newSprite(2);
        personagens[3] = GeradorDeSprite.newSprite(3);
    }

    public static void restaurarDados() {
        Personagem fazendeiro = (Personagem) personagens[0];
        Personagem vaca = (Personagem) personagens[1];
        Personagem nave = (Personagem) personagens[2];
        fazendeiro.setEnergia(100);
        vaca.setEnergia(150);
        nave.setEnergia(100);
        municao = 3;
    }

    public static int atirar() {
        if (tentativaAtirar == 0) {
            tentativaAtirar = 1;
            Missil missil = (Missil) personagens[3];
            int dadoFazendeiro = new Random().nextInt(10) * missil.getVelocidade();
            int dadoNave = new Random().nextInt(10);

            if (dadoFazendeiro > dadoNave) {
                Personagem nave = (Personagem) personagens[2];
                nave.setEnergia(nave.getEnergia() - missil.getDano());
                municao--;
                return 50;
            } else {
                municao--;
                return 0;
            }
        } else {
            return -1;
        }
    }

    public static int bombaNave() {
        int posicaoBomba = new Random().nextInt(3);
        Personagem fazendeiro = (Personagem) personagens[0];

        if (fazendeiro.getPosicao().getX() == posicaoBomba) {
            fazendeiro.setEnergia(fazendeiro.getEnergia() - 34);
            return 34;
        } else {
            return 0;
        }
    }

    public static boolean mover(String direcao) {
        if (tentativaEsquivar == 0) {
            tentativaEsquivar = 1;
            Personagem fazendeiro = (Personagem) personagens[0];
            if ("Esquerda".equalsIgnoreCase(direcao)) {
                fazendeiro.move(0, 1);
            } else if ("Direita".equalsIgnoreCase(direcao)) {
                fazendeiro.move(2, 1);
            }
            return true;
        }
        return false;
    }

    public static int proximoTurno() {
        Personagem fazendeiro = (Personagem) personagens[0];
        Personagem nave = (Personagem) personagens[2];

        tentativaAtirar = 0;
        tentativaEsquivar = 0;
        fazendeiro.move(1, 1);

        if (nave.getEnergia() <= 0) {
            if (!proximaFase()) {
                return 777;
            } else {
                return 1;
            }
            
        } else if (fazendeiro.getEnergia() <= 0) {
            fase = 1;
            restaurarDados();
            return -1;
        } else if ( municao <= 0) {
            restaurarDados();
            return 0;
        }

        return 22;
    }

    public static boolean proximaFase() {
        fase++;
        if (fase == 4) {
            Personagem fazendeiro = (Personagem) personagens[0];
            fase = 1;
            restaurarDados();
            municao = 6;
            fazendeiro.setEnergia(200);
            return false;
        }
        restaurarDados();
        return true;
    }

    public static int getFase() {
        return fase;
    }

    public static void setFase(int fase) {
        Fase.fase = fase;
    }

    public static Sprite[] getPersonagens() {
        return personagens;
    }

    public static void setPersonagens(Sprite[] personagens) {
        Fase.personagens = personagens;
    }

    public static int getMunicao() {
        return municao;
    }

    public static void setMunicao(int municao) {
        Fase.municao = municao;
    }

    public static int getTentativaAtirar() {
        return tentativaAtirar;
    }

    public static void setTentativaAtirar(int tentativaAtirar) {
        Fase.tentativaAtirar = tentativaAtirar;
    }

    public static int getTentativaEsquivar() {
        return tentativaEsquivar;
    }

    public static void setTentativaEsquivar(int tentativaEsquivar) {
        Fase.tentativaEsquivar = tentativaEsquivar;
    }
}
