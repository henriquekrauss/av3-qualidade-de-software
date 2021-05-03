package br.unisul.view;

import javax.swing.JOptionPane;

import br.unisul.controller.Fase;
import br.unisul.model.Personagem;

public class Jogo {

    public void abrirMenuPrincipal() {
        boolean flag = true;
        while (flag) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Iniciar \n2 - Sair"));
            switch (opcao) {
                case 1:
                    Fase.comecar();
                    this.abrirMenuGame();
                    break;
    
                case 2:
                    flag = false;
                    break;

                default:
                    opcao = 0;
                    break;
            }
        }
    }

    public void abrirMenuGame() {
        Personagem fazendeiro = (Personagem) Fase.getPersonagens()[0];
        Personagem vaca = (Personagem) Fase.getPersonagens()[1];
        Personagem nave = (Personagem) Fase.getPersonagens()[2];
        boolean flag = true;
        while (flag) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Fase " + Fase.getFase() + "\n\nFazendeiro - " + fazendeiro.getEnergia() + "\nVaca - " + vaca.getEnergia() + "\nNave - " + nave.getEnergia() + "\n\n 1 - Atirar, 2 - Mover pra Esquerda, 3 - Mover pra Direita, 4 - Próximo Turno"));
            switch (opcao) {
                case 1:
                    int dano = Fase.atirar();
                    if (dano > 0) {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro acertou a nave e deu " + dano);
                    } else if (dano == 0) {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro errou a nave e não deu dano");
                    } else if (dano == -1) {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro já atirou nessa rodada");
                    }
                    break;

                case 2:
                    boolean moveuEsq = Fase.mover("Esquerda");
                    if (moveuEsq) {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro se moveu para a esquerda");
                    } else {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro já se moveu nessa rodada");
                    }
                    break;

                case 3:
                    boolean moveuDir = Fase.mover("Direita");
                    if (moveuDir) {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro se moveu para a Direita");
                    } else {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro já se moveu nessa rodada");
                    }
                    break;

                case 4:
                    int danoBomba = Fase.bombaNave();
                    if (danoBomba > 0) {
                        JOptionPane.showMessageDialog(null, "A nave acertou a bomba e deu " + danoBomba);
                    } else {
                        JOptionPane.showMessageDialog(null, "A nave errou a bomba");
                    }

                    int resultadoTurno = Fase.proximoTurno();
                    if (resultadoTurno == 1) {
                        JOptionPane.showMessageDialog(null, "A Nave foi eliminada, passe para a próxima fase");
                    } else if (resultadoTurno == -1) {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro foi eliminado! GAME OVER");
                    } else if (resultadoTurno == 0) {
                        JOptionPane.showMessageDialog(null, "O Fazendeiro ficou sem munição e vaca foi levada, retorne ao inicio da fase");
                    } else if (resultadoTurno == 777) {
                        JOptionPane.showMessageDialog(null, "Parabéns você ganhou!");
                    }
                    break;
    
                case 5:
                    opcao = 5;
                    break;

                default:
                    opcao = 0;
                    break;
            }
        }
    }
}
