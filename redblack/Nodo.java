package redblack;

import java.awt.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

public class Nodo {
    private int valor;
    private Nodo esquerda;
    private Nodo direita;
    private boolean isNull;
    private Color cor;
    private Nodo pai;
    
    public Nodo(){
        
    }
    
    public Nodo(int valor){
        this.isNull = false;
        this.valor = valor;
        this.esquerda = criarFolhaVazia();
        this.direita = criarFolhaVazia();
        this.cor = RED;
    }
    
    private Nodo criarFolhaVazia(){
        Nodo no = new Nodo();
        no.isNull = true;
        no.cor = BLACK;
        return no;
    }
    
    public boolean folhaNula(){
        return this.isNull;
    }
    
    public void setFolha(){
        this.isNull = true;
        this.cor = BLACK;
        this.valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Nodo esquerda) {
        this.esquerda = esquerda;
    }

    public Nodo getDireita() {
        return direita;
    }

    public void setDireita(Nodo direita) {
        this.direita = direita;
    }

    public boolean isIsNull() {
        return isNull;
    }

    public void setIsNull(boolean isNull) {
        this.isNull = isNull;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Nodo getPai() {
        return pai;
    }

    public void setPai(Nodo pai) {
        this.pai = pai;
    }
    
}
