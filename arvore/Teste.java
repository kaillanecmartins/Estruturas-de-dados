package arvore;

public class Teste {
    public static void main(String[] args) {
        Arvore a1 = new Arvore();
        
        a1.inserir(5);
        a1.inserir(20);
        a1.inserir(3);
        a1.inserir(40);
        a1.emOrdem(a1.getRaiz());
        System.out.println(" ");
        a1.buscar(15);
        a1.remover(20);
        a1.emOrdem(a1.getRaiz());
        
    }
}
