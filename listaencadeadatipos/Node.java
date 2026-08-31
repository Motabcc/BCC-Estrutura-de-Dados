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

class ListaGE{
    public Node primeiro;
    public Node ultimo;

    public void insereAntecessor(Node p, int elemento) {
        Node novo = new Node(elemento);

    }
}
