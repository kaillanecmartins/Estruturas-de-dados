package lista;

//import lista.ListaLigada;

public class ListaLigada {
    private Nodo raiz;
    
    public void imprimir(){
        Nodo atual = raiz;
        while(atual != null){
            System.out.print(atual.getValor() + " --> ");
            atual = atual.getProx();
        }
        System.out.println("null");
    }
    
    public int tamanho(){
        if(raiz == null){
            return 0;
        }
        int count = 0;
        Nodo atual = raiz;
        while (atual != null){
            count++;
            atual = atual.getProx();
        }
        return count;
    }
    
    public void inserir(int posicao, int valor){
        Nodo no = new Nodo(valor);
        
        if(posicao == 1){
            no.setProx(raiz);
            raiz = no;
        }else{
           Nodo previsao = raiz;
           int count = 1;
           
           while(count < posicao - 1){
               previsao = previsao.getProx();
               count++;
           }
           
           Nodo atual = previsao.getProx();
           previsao.setProx(no);
           no.setProx(atual);
        }
    }
    
    public void deletar(int posicao){
      if(posicao == 1){
          raiz = raiz.getProx();
      }else{
          Nodo previsao = raiz;
          int count = 1;
          while(count < posicao - 1){
              previsao = previsao.getProx();
              count++;
          }
          
          Nodo atual = previsao.getProx();
          previsao.setProx(atual.getProx());
          
      }
    }
    
}
