package listaencadeada;

public class Node {
    public int info;
    public Node proximo;

    public Node(int info){
        //Node lista;
        this.info=info;
        this.proximo = null;
    }
}
class ListaX{
    //Descritor(heaad)
    public Node primeiro;
    public Node ultimo;

    //Aponta pro primeiro imprime e atualiza o ponteiro pro proximo.
    public void imprimir(){
        Node p = this.primeiro;
        while(p != null){
            System.out.println(p.info);
            p= p.proximo;
        }
    }
    //Verifica se a lista tá vazia.
    public boolean vazia(){
        if(this.primeiro == null){
            return  true;
        }
        else{
            return false;
        }
    }

    public void inserePrimeiro(int info) {
        Node p =new Node(info);
        if(this.vazia()){
            this.primeiro= p;
            this.ultimo =p;
        }else {
            p.proximo = this.primeiro;
            this.primeiro = p;
        }   }
    public void insereUltimo(int info){
        Node p = new Node(info);
        if(this.vazia()){
            this.primeiro =p;
        }else{
            this.ultimo.proximo=p;
        }
        this.ultimo=p;
    }
    public Node insereDepois(Node p,int info){
        Node novo = new Node(info);

        novo.proximo=p.proximo;
        p.proximo=novo;
        return novo;
    }


    public void insereOrdenado(int info) {
        //a) lista esta vazia
        if(this.vazia()){
            this.inserePrimeiro(info);
        }
        //b) elemento é menor que o primeiro
        else if(info <= this.primeiro.info){
            this.inserePrimeiro(info);
        }
        //c) elemento é maior que o último
        else if(info>= this.ultimo.info){
            this.insereUltimo(info);

        }
        //d) elemento é intermediário
        //Deixa Q como referência do elemento anterior e avança o P
        else{
            Node p = this.primeiro;
            Node q = null;
            while(p.info<info){
                q=p;
                p= p.proximo;
            }
            this.insereDepois(q,info);
        }
    }
}




