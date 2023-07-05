package lista;

public class Teste {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.inserir(1, 3);
        lista.inserir(2, 5);
        lista.inserir(1, 2);
        lista.imprimir();
        lista.deletar(3);
        lista.imprimir();
    }
}
