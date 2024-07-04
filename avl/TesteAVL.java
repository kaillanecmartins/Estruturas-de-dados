package avl;

public class TesteAVL {
    public static void main(String[] args) {
        ArvoreAVL arv = new ArvoreAVL();
        arv.inserir(50);
        arv.inserir(10);
        arv.inserir(35);
        arv.imprimirArvore();
    }
}
