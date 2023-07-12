package fila;

public class Teste {
    public static void main(String[] args) {
        Fila f1 = new Fila();
        
        f1.adicionar(3);
        f1.adicionar(15);
        f1.adicionar(90);
        f1.adicionar(19);
        f1.imprimir();
        System.out.println("primeiro: " + f1.primeiro());
        f1.remover();
        System.out.println("primeiro: " + f1.primeiro());
        System.out.println("último: " + f1.ultimo());
        f1.imprimir();
        
    }
}
