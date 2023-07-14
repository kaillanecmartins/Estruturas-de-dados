package arvore;

public class Arvore {
    private Nodo raiz;
    
    public void preOrdem(Nodo raiz){
        if(raiz == null){
            return;
        }
        
        System.out.print(raiz.getValor() + " ");
        preOrdem(raiz.getEsquerda());
        preOrdem(raiz.getDireita());
    }
    
    public void emOrdem(Nodo raiz){
        if(raiz == null){
            return;
        }
        
        emOrdem(raiz.getEsquerda());
        System.out.print(raiz.getValor() + " ");
        emOrdem(raiz.getDireita());
        
    }
    
    public void posOrdem(Nodo raiz){
        if(raiz == null){
            return;
        }
        
        posOrdem(raiz.getEsquerda());
        posOrdem(raiz.getDireita());
        System.out.print(raiz.getValor() + " ");
    }
    
    public void inserir(int valor){
        raiz = inserir(raiz, valor);
    }
    
    public Nodo inserir(Nodo raiz, int valor){
        if(raiz == null){
            raiz = new Nodo(valor);
            return raiz;
        }
        
        if(valor < raiz.getValor()){
            raiz.setEsquerda(inserir(raiz.getEsquerda(), valor));
            
        }else{
            raiz.setDireita(inserir(raiz.getDireita(), valor));
        }
        
        return raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public void buscar(int valor){
        Nodo resultado = buscar(raiz, valor);
        
        if(resultado != null){
            System.out.println("Valor encontrado com sucesso!");
        }else{
            System.out.println("valor inexistente na tree");
        }
    }
    
    public Nodo buscar(Nodo raiz, int valor){
        if(raiz == null || raiz.getValor() == valor){
            return raiz;
        }
        
        if(valor < raiz.getValor()){
            return buscar(raiz.getEsquerda(), valor);
        }else {
            return buscar(raiz.getDireita(), valor);
        }
    }
    
    public boolean remover(int valor){
        //buscar o elemento na árvore
        Nodo atual = this.raiz;
        Nodo paiAtual = null;
        
        while(atual != null){
            if (atual.getValor() == valor){
                break;                
            }else if (valor < atual.getValor()){ //valor procurado é menor que o atual 
                paiAtual = atual;
                atual = atual.getEsquerda();
            }else{
                paiAtual = atual;
                atual = atual.getDireita();
            }
        }
        //verifica se existe o elemento
        if (atual != null){
            
            //elemento tem 2 filhos ou elemento tem somente filho à direita
            if (atual.getDireita() != null){
                
                Nodo substituto = atual.getDireita();
                Nodo paiSubstituto = atual;
                while(substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                }
                substituto.setEsquerda(atual.getEsquerda());
                if (paiAtual != null){
                    if (atual.getValor() < paiAtual.getValor()){ //atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    }else{
                        paiAtual.setDireita(substituto);
                    }
                }else{ //se não tem paiAtual, então é a raiz
                    this.raiz = substituto;
                    paiSubstituto.setEsquerda(null);
                    this.raiz.setDireita(paiSubstituto);
                    this.raiz.setEsquerda(atual.getEsquerda());
                }
                
                //removeu o elemento da árvore
                if (substituto.getValor() < paiSubstituto.getValor()){ //substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }else{
                    paiSubstituto.setDireita(null);
                }
                
            }else if (atual.getEsquerda() != null){ //tem filho só à esquerda
                Nodo substituto = atual.getEsquerda();
                Nodo paiSubstituto = atual;
                while(substituto.getDireita() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                }
                if (paiAtual != null){
                    if (atual.getValor() < paiAtual.getValor()){ //atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    }else{
                        paiAtual.setDireita(substituto);
                    }
                }else{ //se for a raiz
                    this.raiz = substituto;
                }
                
                //removeu o elemento da árvore
                if (substituto.getValor() < paiSubstituto.getValor()){ //substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }else{
                    paiSubstituto.setDireita(null);
                }
            }else{ //não tem filho
                if (paiAtual != null){
                    if (atual.getValor() < paiAtual.getValor()){ //atual < paiAtual
                        paiAtual.setEsquerda(null);
                    }else{
                        paiAtual.setDireita(null);
                    }
                }else{ //é a raiz
                    this.raiz = null;
                }
            }
            
            return true;
        }else{
            return false;
        }        
    }
}
