package listaencadeadatipos;

//Lista Duplamente Encadeada
public class Node {
    public int info;
    public Node proximo;
    public Node anterior;

    public Node(int info){
        this.info =info;
        this.proximo=null;
        this.anterior=null;
    }
}

class ListaDuplamenteEncadeada{
    public Node primeiro;
    public Node ultimo;

    public boolean vazia(){
        return this.primeiro ==null;
    }

    public void insereAntecessor(Node p, int elemento) {
        Node novo = new Node(elemento);
        if(p == this.primeiro){
            novo.proximo = p;
            p.anterior = novo;
            this.primeiro=novo;
        }
        else{
            novo.proximo =p;
            novo.anterior = p.anterior;

            p.anterior.proximo =novo;
            p.anterior= novo;
        }
    }
}
