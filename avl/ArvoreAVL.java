package avl;

import java.util.NoSuchElementException;

public class ArvoreAVL {
    
   Nodo raiz;
   int tamanho;
   
   public ArvoreAVL(){
       this.tamanho = 0;
   }
   
   public void inserir(int valor){
       this.tamanho++;
       if(this.raiz == null){
           this.raiz = new Nodo(valor);
       }
       else{
           this.inserir(this.raiz, valor);
       }
   }
   
   private void inserir(Nodo no, int valor){
       if(no.getValor() == valor){
           return;
       }else if(no.getValor() > valor){
           if(no.temFilhoEsq()){
               this.inserir(no.getEsquerda(), valor);
           }else{
               no.setEsquerda(new Nodo(valor));
               this.atualizar(no);
           }
       }
       else{
           if(no.ehFilhoDir()){
               this.inserir(no.getDireita(), valor);
           }else{
               no.setDireita(new Nodo(valor));
               this.atualizar(no);
           }
       }
   }
   
   public Nodo buscar(int valor){
       if(this.raiz == null){
           throw new NoSuchElementException("o valor" + valor + "não existe");
       }else{
           return this.buscar(this.raiz, valor);
       }
   }
   
   private Nodo buscar(Nodo no, int valor){
       if(no.getValor() == valor){
           return no;
       }else if(no.getValor() > valor){
           if(no.temFilhoEsq()){
               return this.buscar(no.getEsquerda(), valor);
           }else{
               throw new NoSuchElementException("o valor" + valor + "não existe");
           }
       }
       else{
           if(no.temFilhoDir()){
               return this.buscar(no.getDireita(), valor);
           }else{
               throw new NoSuchElementException("o valor" + valor + "não existe");
           }
       }
   }
   
   public void deletar(int valor) throws NoSuchElementException{
       Nodo atual = this.buscar(valor);
       
       if(this.raiz == atual){
           if(this.raiz.ehFolha()){
               this.tamanho--;
               this.raiz = null;
           }else if(this.raiz.temFilho()){
               Nodo temp = this.raiz.getEsquerda().encontraMax();
               int tempValor = temp.getValor();
               this.deletar(tempValor);
               atual.setValor(tempValor);
           }
           else{
               this.tamanho--;
               if(this.raiz.temFilhoEsq()){
                   this.raiz = this.raiz.getEsquerda();
                   this.raiz.setPai(null);
               }else{
                   this.raiz = this.raiz.getDireita();
                   this.raiz.setPai(null);
               }
           }
       }
       else{
           Nodo pai = atual.getPai();
           if(atual.ehFolha()){
               this.tamanho--;
               if(atual.ehFilhoEsq()){
                   atual.getPai().setEsquerda(null);
               }else{
                   atual.getPai().setDireita(null);
               }
               this.atualizar(pai);
           }else if(atual.temFilho()){
               Nodo temp = atual.getEsquerda().encontraMax();
               int tempValor = temp.getValor();
               this.deletar(tempValor);
               atual.setValor(tempValor);
           }
           
           else{
               this.tamanho--;
               if(atual.temFilhoEsq()){
                   if(atual.ehFilhoEsq()){
                       atual.getPai().setEsquerda(atual.getEsquerda());
                       atual.getEsquerda().setPai(atual.getPai());
                   }
                   else{
                       atual.getPai().setDireita(atual.getEsquerda());
                       atual.getEsquerda().setPai(atual.getPai());
                   }
               }
               else{
                   if(atual.ehFilhoEsq()){
                       atual.getPai().setEsquerda(atual.getDireita());
                       atual.getDireita().setPai(atual.getPai());
                   }
                   else{
                       atual.getPai().setDireita(atual.getDireita());
                       atual.getDireita().setPai(atual.getPai());
                   }
               }
               this.atualizar(pai);
           }
       }
   }
   
   public int tamanho(){
       return this.tamanho;
   }
   
   private void atualizar(Nodo no){
       int antigoFatorBalanceamento = no.getFatorBalanceamento();
       if(no.temFilhoEsq()){
           no.setTamSubArvEsq(Math.max(no.getEsquerda().getTamSubArvEsq(), no.getEsquerda().getTamSubArvDir()) + 1);
       }else{
           no.setTamSubArvEsq(0);
       }
       if(no.temFilhoDir()){
           no.setTamSubArvDir(Math.max(no.getDireita().getTamSubArvEsq(), no.getDireita().getTamSubArvDir()) + 1);
       }else{
           no.setTamSubArvDir(0);
       }
       no.setFatorBalanceamento(no.getTamSubArvEsq() - no.getTamSubArvDir());
       if(no.getFatorBalanceamento() < -1 || no.getFatorBalanceamento() > 1){
           this.rebalancear(no);
           return;
       }
       if(antigoFatorBalanceamento != no.getFatorBalanceamento() && no.temPai()){
           atualizar(no.getPai());
       }
   }
   
   private void rebalancear(Nodo no){
       if(no.getFatorBalanceamento() < 0){
           if(no.getDireita().getFatorBalanceamento() > 0){
               this.rotacaoDireita(no.getDireita());
           }else{
               this.rotacaoEsquerda(no);
           }
       }else{
           if(no.getEsquerda().getFatorBalanceamento() < 0){
               this.rotacaoEsquerda(no.getEsquerda());
           }else{
               this.rotacaoDireita(no);
           }
       }
   }
   
   private void rotacaoEsquerda(Nodo no){
       Nodo raizAntiga = no;
       Nodo novaRaiz = no.getDireita();
       raizAntiga.setDireita(novaRaiz.getEsquerda());
       
       if(novaRaiz.temFilhoEsq()){
           novaRaiz.getEsquerda().setPai(raizAntiga);
       }
       novaRaiz.setPai(raizAntiga.getPai());
       if(raizAntiga.temPai()){
           if(raizAntiga.ehFilhoEsq()){
               raizAntiga.getPai().setEsquerda(novaRaiz);
           }else{
               raizAntiga.getPai().setDireita(novaRaiz);
           }
       }else{
           this.raiz = novaRaiz;
       }
       raizAntiga.setPai(novaRaiz);
       novaRaiz.setEsquerda(raizAntiga);
       this.atualizar(raizAntiga);
   }
 
   private void rotacaoDireita(Nodo no){
       Nodo raizAntiga = no;
       Nodo novaRaiz = no.getDireita();
       raizAntiga.setEsquerda(novaRaiz.getDireita());
       if(novaRaiz.temFilhoDir()){
           novaRaiz.getDireita().setPai(raizAntiga);
       }
       novaRaiz.setPai(raizAntiga.getPai());
       if(raizAntiga.temPai()){
           if(raizAntiga.ehFilhoEsq()){
               raizAntiga.getPai().setEsquerda(novaRaiz);
           }else{
               raizAntiga.getPai().setDireita(novaRaiz);
           }
       }
       else{
           this.raiz = novaRaiz;
       }
       raizAntiga.setPai(novaRaiz);
       novaRaiz.setDireita(raizAntiga);
       this.atualizar(raizAntiga);
   }
   
    public void imprimirArvore() {
        imprimirArvore(raiz);
    }

    private void imprimirArvore(Nodo nodo) {
        if (nodo != null) {
            imprimirArvore(nodo.getEsquerda());
            System.out.print(nodo.getValor());
            imprimirArvore(nodo.getDireita());
        }
    }
}
