package splay;


public class Nodo {
    int chave;
    Nodo esquerda, direita, pai;

    public Nodo(int chave) {
        this.chave = chave;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}

