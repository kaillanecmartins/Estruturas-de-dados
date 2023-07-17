package avl;

public class Nodo {
    private int valor;
    private int tamSubArvEsq, tamSubArvDir, fatorBalanceamento;
    private Nodo direita, esquerda, pai;

    
    public Nodo(){
        
    }
    
    public Nodo(int valor){
        this();
        this.valor = valor;
    }
    
    public Nodo(int valor, Nodo pai){
        this();
        this.valor = valor;
        this.pai = pai;
    }
    
    public boolean temFilhoEsq(){
        return this.esquerda != null;
    }
    
    public boolean temFilhoDir(){
        return this.direita != null;
    }
    
    public boolean ehFolha(){
        return !this.temFilhoEsq() && this.temFilhoDir();
    }
    
    public boolean temFilho(){
        return this.temFilhoEsq() && this.temFilhoDir();
    }
    
    public boolean temPai(){
        return this.pai != null;
    }
    
    public boolean ehFilhoEsq(){
        return this.pai.esquerda == this;
    }
    
    public boolean ehFilhoDir(){
        return this.pai.direita == this;
    }
    
    public Nodo encontraMin(){
        if(this.temFilhoEsq()){
            return this.esquerda.encontraMin();
        }else{
            return this;
        }
    }
    
    public Nodo encontraMax(){
        if(this.ehFilhoDir()){
            return this.direita.encontraMax();
        }else{
            return this;
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTamSubArvEsq() {
        return tamSubArvEsq;
    }

    public void setTamSubArvEsq(int tamSubArvEsq) {
        this.tamSubArvEsq = tamSubArvEsq;
    }

    public int getTamSubArvDir() {
        return tamSubArvDir;
    }

    public void setTamSubArvDir(int tamSubArvDir) {
        this.tamSubArvDir = tamSubArvDir;
    }

    public int getFatorBalanceamento() {
        return fatorBalanceamento;
    }

    public void setFatorBalanceamento(int fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public Nodo getDireita() {
        return direita;
    }

    public void setDireita(Nodo direita) {
        this.direita = direita;
    }

    public Nodo getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Nodo esquerda) {
        this.esquerda = esquerda;
    }

    public Nodo getPai() {
        return pai;
    }

    public void setPai(Nodo pai) {
        this.pai = pai;
    }
    
}
