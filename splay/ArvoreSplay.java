package splay;

public class ArvoreSplay {
    private Nodo raiz;

    public ArvoreSplay() {
        raiz = null;
    }

    // Rotação para a direita
    private void rotacaoDireita(Nodo x) {
        Nodo y = x.esquerda;
        x.esquerda = y.direita;
        if (y.direita != null) {
            y.direita.pai = x;
        }
        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.direita) {
            x.pai.direita = y;
        } else {
            x.pai.esquerda = y;
        }
        y.direita = x;
        x.pai = y;
    }

    // Rotação para a esquerda
    private void rotacaoEsquerda(Nodo x) {
        Nodo y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) {
            y.esquerda.pai = x;
        }
        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }
        y.esquerda = x;
        x.pai = y;
    }

    // Função Splay
    private void splay(Nodo x) {
        while (x.pai != null) {
            if (x.pai.pai == null) {
                if (x.pai.esquerda == x) {
                    rotacaoDireita(x.pai);
                } else {
                    rotacaoEsquerda(x.pai);
                }
            } else if (x.pai.esquerda == x && x.pai.pai.esquerda == x.pai) {
                rotacaoDireita(x.pai.pai);
                rotacaoDireita(x.pai);
            } else if (x.pai.direita == x && x.pai.pai.direita == x.pai) {
                rotacaoEsquerda(x.pai.pai);
                rotacaoEsquerda(x.pai);
            } else if (x.pai.esquerda == x && x.pai.pai.direita == x.pai) {
                rotacaoDireita(x.pai);
                rotacaoEsquerda(x.pai);
            } else {
                rotacaoEsquerda(x.pai);
                rotacaoDireita(x.pai);
            }
        }
    }

    // Função de inserção
    public void inserir(int chave) {
        Nodo z = raiz;
        Nodo p = null;
        while (z != null) {
            p = z;
            if (chave < z.chave) {
                z = z.esquerda;
            } else {
                z = z.direita;
            }
        }
        z = new Nodo(chave);
        z.pai = p;
        if (p == null) {
            raiz = z;
        } else if (chave < p.chave) {
            p.esquerda = z;
        } else {
            p.direita = z;
        }
        splay(z);
    }

    // Função de busca
    public Nodo buscar(int chave) {
        Nodo z = raiz;
        while (z != null) {
            if (chave < z.chave) {
                z = z.esquerda;
            } else if (chave > z.chave) {
                z = z.direita;
            } else {
                splay(z);
                return z;
            }
        }
        return null;
    }

    // Função para encontrar o nó com o valor mínimo
    private Nodo minimo(Nodo x) {
        while (x.esquerda != null) {
            x = x.esquerda;
        }
        return x;
    }

    // Função para remover um nó
    public void remover(int chave) {
        Nodo z = buscar(chave);
        if (z == null) {
            return;
        }
        splay(z);
        if (z.esquerda == null) {
            substituir(z, z.direita);
        } else if (z.direita == null) {
            substituir(z, z.esquerda);
        } else {
            Nodo y = minimo(z.direita);
            if (y.pai != z) {
                substituir(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
            }
            substituir(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
        }
    }

    // Função para substituir um nó
    private void substituir(Nodo u, Nodo v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        if (v != null) {
            v.pai = u.pai;
        }
    }

    // Função para exibir a árvore em ordem
    public void exibirEmOrdem() {
        exibirEmOrdem(raiz);
        System.out.println();
    }

    private void exibirEmOrdem(Nodo nodo) {
        if (nodo != null) {
            exibirEmOrdem(nodo.esquerda);
            System.out.print(nodo.chave + " ");
            exibirEmOrdem(nodo.direita);
        }
    }
}

