package tde2;


class Node{
    public int info;
    public Node proximo;

    public Node(int info){
        this.info = info;
        this.proximo= null;
    }
}
public class ListaEncadeada {
    public Node primeiro ;
    public Node ultimo ;

    // Verifica se a lista L está vazia
    public boolean vazia(){
        return this.primeiro == null;
    };

    // Insere o elemento info como primeiro na lista L
    public void insere_primeiro(int info){
        Node p = new Node(info);
        if(this.vazia()){
            this.primeiro = p;
            this.ultimo = p;
        }
        else{
            //aponta pro primeiro e insere o dado
            p.proximo = this.primeiro;
            this.primeiro = p;
        }
    };

    // Insere o elemento info depois do nó No
    public Node insere_depois(Node p, int info){
        Node novo = new Node(info);
        if(this.vazia()){
            this.insere_primeiro(info);
        }
        else{
            novo.proximo= p.proximo;
            p.proximo = novo;
        }
        return novo;
    }
    // Insere o elemento info como último na lista L
    public void insere_ultimo(int info){
        Node p = new Node(info);
        if(this.vazia()){
            this.insere_primeiro(info);
        }
        else{
            p.proximo =this.ultimo;
            this.ultimo=p;
        }
    };
    void insere_ordenado(int info){}; // Insere o elemento info de maneira ordenada na lista

    // Mostra em Tela os Elementos da Lista L
    void mostra_lista(){
        Node p = this.primeiro;
        while(p != null ){
            System.out.println(p.info);
            p = p.proximo;
        }
    };
    // Retira o primeiro elemento da Lista e retorna o valor da info do No
    public int retira_primeiro(){
        if(this.vazia()){
           return -1;
        }
        Node p =this.primeiro ;
        this.primeiro = p.proximo;
        return p.info;

    };
    // Retira o último elemento da Lista e retorna a informação do Nó
    public int retira_ultimo(){
        if(this.vazia()){
            return -1;
        }
        int valor_final = this.ultimo.info;

        if(this.primeiro==this.ultimo){
            this.primeiro = null;
            this.ultimo = null;
            return valor_final;
        }
        Node p =this.primeiro;
        while(p.proximo != this.ultimo){
            p= p.proximo ;
        }
        p.proximo = null;
        this.ultimo =p;
        return valor_final;
    };

    // Retira o elemento posterior ao nó No e retorna a sua informação
    public int retira_depois(Node no){
        if(this.vazia()){
            return -1;
        }

        Node p = no.proximo;
        no.proximo = p.proximo;

        if(p == this.ultimo){
            this.ultimo = no;
        }

        return p.info;
    };
    // Retorna a informação do último elemento da Lista
    public int ultimo_elemento(){
        return this.ultimo.info;
    }
};








}
