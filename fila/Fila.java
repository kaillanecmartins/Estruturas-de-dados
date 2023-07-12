package fila;

import lista.*;

public class Fila{
    private Nodo primeiro;
    private Nodo ultimo;
    private int tamanho;
    
    public Fila(){
        this.primeiro = null;
        this.ultimo = null;
        tamanho = 0;
    }
    
    public int tamanho(){
        return tamanho;
    }
    
    public boolean isEmpty(){
        return tamanho == 0;
    }
    
    public void adicionar(int valor){
        Nodo atual = new Nodo(valor);
        if(isEmpty()){
            primeiro = atual;
        }else{
            ultimo.setProx(atual);
        }
        
        ultimo = atual;
        tamanho++;
    }
    
    public int remover(){
        if(isEmpty()){
            System.err.println("FILA VAZIA!!!");
        }
        
        int resultado = primeiro.getValor();
        primeiro = primeiro.getProx();
        
        if(primeiro == null){
            ultimo = null;
        }
        tamanho--;
        return resultado;
    }
    
    public int primeiro(){
        if(isEmpty()){
            System.err.println("FILA VAZIA!!!");
        }
        return primeiro.getValor();
    }
    
    public int ultimo(){
        if(isEmpty()){
            System.err.println("FILA VAZIA!!!");
        }
        return ultimo.getValor();
    }
    
    public void imprimir(){
        if(isEmpty()){
            return;
        }
        Nodo atual = primeiro;
        while(atual != null){
            System.out.print(atual.getValor() + " --> ");
            atual  = atual.getProx();
        }
        System.out.println("null");
    }
}
