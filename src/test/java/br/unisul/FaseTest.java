package br.unisul;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.unisul.controller.Fase;
import br.unisul.model.Missil;
import br.unisul.model.Personagem;

public class FaseTest {
    @Test
    public void faseDeveIniciarCorretamente() {
        Fase.comecar();
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        Personagem vaca = (Personagem) Fase.getPersonagens()[1];
        Personagem nave = (Personagem) Fase.getPersonagens()[2];
        Missil missil = (Missil) Fase.getPersonagens()[3];
        assertEquals(1, Fase.getFase());
        assertEquals(3, Fase.getMunicao());
        assertEquals(100, fazendeiro.getEnergia());
        assertEquals(150, vaca.getEnergia());
        assertEquals(100, nave.getEnergia());
        assertEquals(1, missil.getVelocidade());
        assertEquals(50, missil.getDano());
    }

    @Test
    public void fazendeiroDeveDarDanoNaNave() {
        Fase.comecar();
        Personagem nave = (Personagem) Fase.getPersonagens()[2];
        Missil missil = (Missil) Fase.getPersonagens()[3];
        missil.setVelocidade(100);
        Fase.atirar();
        assertEquals(50, nave.getEnergia());
    }

    @Test
    public void deveDiminuirMunicao() {
        Fase.comecar();
        Fase.setMunicao(3);
        Fase.atirar();
        assertEquals(2, Fase.getMunicao());
    }

    @Test
    public void fazendeiroDeveMoverParaEsquerda() {
        Fase.comecar();
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        fazendeiro.getPosicao().setX(1);
        Fase.mover("Esquerda");
        int fazendeiroX = fazendeiro.getPosicao().getX();
        assertEquals(0, fazendeiroX);
    }

    @Test
    public void fazendeiroDeveMoverParaDireita() {
        Fase.comecar();
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        fazendeiro.getPosicao().setX(1);
        Fase.mover("Direita");
        int fazendeiroX = fazendeiro.getPosicao().getX();
        assertEquals(2, fazendeiroX);
    }

    @Test
    public void passarParaProximaFaseSeNaveMorrer() {
        Fase.comecar();
        Missil missil = (Missil) Fase.getPersonagens()[3];
        missil.setVelocidade(100);
        missil.setDano(100);
        Fase.atirar();
        Fase.proximoTurno();
        assertEquals(2, Fase.getFase());
    }

    @Test
    public void reiniciarFaseSeMunicaoAcabar() {
        Fase.comecar();
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        Personagem vaca = (Personagem) Fase.getPersonagens()[1];
        Personagem nave = (Personagem) Fase.getPersonagens()[2];
        fazendeiro.setEnergia(30);
        vaca.setEnergia(50);
        nave.setEnergia(25);
        Fase.setFase(3);
        Fase.setMunicao(0);
        Fase.proximoTurno();
        assertEquals(100, fazendeiro.getEnergia());
        assertEquals(150, vaca.getEnergia());
        assertEquals(100, nave.getEnergia());
        assertEquals(3, Fase.getFase());
    }

    @Test
    public void reiniciarJogoSeFazendeiroMorrer() {
        Fase.comecar();
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        Fase.setFase(3);
        fazendeiro.setEnergia(0);
        Fase.proximoTurno();
        assertEquals(1, Fase.getFase());
    }

    @Test
    public void restaurarVidaEmMudançaDeFase() {
        Fase.comecar();
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        Personagem vaca = (Personagem) Fase.getPersonagens()[1];
        Personagem nave = (Personagem) Fase.getPersonagens()[2];
        fazendeiro.setEnergia(0);
        vaca.setEnergia(50);
        nave.setEnergia(25);
        Fase.proximoTurno();
        assertEquals(100, fazendeiro.getEnergia());
        assertEquals(150, vaca.getEnergia());
        assertEquals(100, nave.getEnergia());
    }

    @Test
    public void deveZerarAoPassarDaFase3() {
        Fase.comecar();
        Missil missil = (Missil) Fase.getPersonagens()[3];
        Fase.setFase(3);
        missil.setVelocidade(100);
        missil.setDano(100);
        Fase.atirar();
        Fase.proximoTurno();
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        assertEquals(200, fazendeiro.getEnergia());
        assertEquals(6, Fase.getMunicao());
    }
}
