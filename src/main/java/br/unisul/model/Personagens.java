package br.unisul.model;

public enum Personagens {
    Fazendeiro {
        @Override
        public Personagem criarPersonagem() {
            return new Personagem(100, 1, 1);
        }
    }, Vaca {
        @Override
        public Personagem criarPersonagem() {
            return new Personagem(150);
        }
    }, Nave {
        @Override
        public Personagem criarPersonagem() {
            return new Personagem(100);
        }
    };
    public abstract Personagem criarPersonagem();
}
