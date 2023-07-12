package pilha;

import java.util.EmptyStackException;
import lista.*;

public class Pilha {
    private Nodo topo;
    private int tamanho;
    
    public Pilha(){
        topo = null;
        tamanho = 0;
    }
    
    public int tamanho(){
        return tamanho;
    }
    
    public boolean isEmpty(){
        return tamanho == 0;
    }
    
    public void empilhar(int valor){
        Nodo atual = new Nodo(valor);
        atual.setProx(topo);
        topo = atual;
        tamanho++;
    }
    
    public int desempilhar(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int resultado = topo.getValor();
        topo = topo.getProx();
        tamanho--;
        return resultado;
    }
    
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return topo.getValor();
    }
    
}
