package tde2;

class Node {
    public int info;
    public Node proximo;

    public Node(int info) {
        this.info = info;
        this.proximo = null;
    }
}

public class ListaEncadeada {
    public Node primeiro;
    public Node ultimo;

    public boolean vazia() {
        return this.primeiro == null;
    }

    public void insere_primeiro(int info) {
        Node p = new Node(info);
        if (this.vazia()) {
            this.primeiro = p;
            this.ultimo = p;
        } else {
            p.proximo = this.primeiro;
            this.primeiro = p;
        }
    }

    public Node insere_depois(Node p, int info) {
        Node novo = new Node(info);
        if (this.vazia()) {
            this.insere_primeiro(info);
        } else {
            novo.proximo = p.proximo;
            p.proximo = novo;
        }
        return novo;
    }

    public void insere_ultimo(int info) {
        Node p = new Node(info);
        if (this.vazia()) {
            this.insere_primeiro(info);
        } else {
            this.ultimo.proximo = p;
            this.ultimo = p;
        }
    }

    public void insere_ordenado(int info) {
        if (this.vazia() || info <= this.primeiro.info) {
            this.insere_primeiro(info);
        } else if (info >= this.ultimo.info) {
            this.insere_ultimo(info);
        } else {
            Node q = null;
            Node p = this.primeiro;

            while (p.info < info) {
                q = p;
                p = p.proximo;
            }
            this.insere_depois(q, info);
        }
    }

    public void mostra_lista() {
        Node p = this.primeiro;
        while (p != null) {
            System.out.println(p.info);
            p = p.proximo;
        }
    }

    public int retira_primeiro() {
        if (this.vazia()) {
            return -1;
        }
        Node p = this.primeiro;
        this.primeiro = p.proximo;
        return p.info;
    }

    public int retira_ultimo() {
        if (this.vazia()) {
            return -1;
        }
        int valor_final = this.ultimo.info;

        if (this.primeiro == this.ultimo) {
            this.primeiro = null;
            this.ultimo = null;
            return valor_final;
        }
        Node p = this.primeiro;
        while (p.proximo != this.ultimo) {
            p = p.proximo;
        }
        p.proximo = null;
        this.ultimo = p;
        return valor_final;
    }

    public int retira_depois(Node no) {
        if (no == null || no.proximo == null) return -1;
        if (this.vazia()) return -1;

        Node p = no.proximo;
        no.proximo = p.proximo;

        if (p == this.ultimo) {
            this.ultimo = no;
        }
        return p.info;
    }

    public int ultimo_elemento() {
        return this.ultimo.info;
    }

    public double similaridade(ListaEncadeada Y) {
        Node p1 = this.primeiro;
        Node p2 = Y.primeiro;

        double somaXY = 0;
        double somaX2 = 0;
        double somaY2 = 0;

        while (p1 != null && p2 != null) {
            somaXY += (p1.info * p2.info);
            somaX2 += (p1.info * p1.info);
            somaY2 += (p2.info * p2.info);

            p1 = p1.proximo;
            p2 = p2.proximo;
        }

        if (somaX2 == 0 || somaY2 == 0) {
            return 0.0;
        }

        return somaXY / (Math.sqrt(somaX2) * Math.sqrt(somaY2));
    }

    public boolean contem(int info) {
        Node p = this.primeiro;
        while (p != null) {
            if (p.info == info) return true;
            p = p.proximo;
        }
        return false;
    }

    public ListaEncadeada intersecao(ListaEncadeada Y) {
        ListaEncadeada listaZ = new ListaEncadeada();
        Node p1 = this.primeiro; // Lista X

        while (p1 != null) {
            Node p2 = Y.primeiro;

            while (p2 != null) {
                if (p1.info == p2.info) {
                    if (!listaZ.contem(p1.info)) {
                        listaZ.insere_ordenado(p1.info);
                    }
                    break;
                }
                p2 = p2.proximo;
            }
            p1 = p1.proximo;
        }

        return listaZ;
    }
}