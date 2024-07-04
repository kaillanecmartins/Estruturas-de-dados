package splay;

public class Main {
    public static void main(String[] args) {
        ArvoreSplay arvore = new ArvoreSplay();

        // Inserção de elementos
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(50);

        // Exibir árvore em ordem
        System.out.println("Árvore em ordem:");
        arvore.exibirEmOrdem();

        // Busca de um elemento
        System.out.println("Buscando pelo elemento 20:");
        arvore.buscar(20);
        arvore.exibirEmOrdem();

        // Remoção de um elemento
        System.out.println("Removendo o elemento 30:");
        arvore.remover(30);
        arvore.exibirEmOrdem();
    }
}

