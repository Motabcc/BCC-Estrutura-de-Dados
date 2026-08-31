package listaencadeadatipos;

public class No {
    public int info;
    public No proximo;

    public No(int info){
        this.info =info;
        this.proximo=null;

    }
}
class ListaCircular{
    public No ultimo;
    public boolean vazia(){
        return ultimo == null;
    }

    public void InsereUltima(int info){
        No p = new No(info);
        if(this.vazia()){
              p.proximo =p;// aponta pra ele mesmo
              this.ultimo=p;// lista atualiza para o novo nó
        }
        // 1 ou mais elementos
        else{
            p.proximo = this.ultimo.proximo;
            this.ultimo.proximo= p;
            this.ultimo = p;

        }
    }
    public void imprimir(){
        if (this.vazia()) {
            System.out.println("Lista vazia");
            return;
        }
        //primeiro elemento da lista pois o ultimo sempre aponta para o primeiro
        No p = this.ultimo.proximo;
        System.out.println(p.info);
        p = p.proximo;

        while(p != this.ultimo.proximo){
            System.out.println(p.info);
            p = p.proximo;
        }
    }
}