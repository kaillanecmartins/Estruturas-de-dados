package pilha;

public class Teste {
    public static void main(String[] args) {
        Pilha p1 = new Pilha();
        
        p1.empilhar(45);
        p1.empilhar(15);
        p1.empilhar(500);
        System.out.println("Topo: " + p1.peek());
        p1.desempilhar();
        System.out.println("Topo: " + p1.peek());
    }
    
}
