public class Node {
    public int info;
    public Node proximo;

    public Node(int info){
        Node lista;
        this.info=info;
        this.proximo= null;
    }
}

class ListaSe{
    public Node primeiro;
    public Node ultimo;

    public boolean vazia(){
        if(this.primeiro == null){
            return true;
        }
        else{return false;}
    }
    public void inserePrimeiro(int info){
        //Criando nó e inserindo a info nele
        Node p =new Node(info);
        if(this.vazia()){
            this.primeiro =p;
            this.ultimo =p;

        }
        else{
            p.proximo=this.primeiro;
            this.primeiro=p;
        }
    }
    public void imprimir(){
        Node p = this.primeiro;
        while(p != null){
            System.out.println(p.info);
            p=p.proximo;
        }
    }

    public void insereUltimo(int info){
        Node p = new Node(info);
        if(this.vazia()) {
        this.primeiro=p;
        }else{
            this.ultimo.proximo=p;
        }
        this.ultimo= p;

    }
}