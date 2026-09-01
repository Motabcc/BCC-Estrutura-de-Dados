class Fila {
    int[] dados;
    int max;
    int topo;

    public Fila(){
        this.max= dados.length-1;
        this.topo =-1;
        this.dados=

    }
    int topo(){
        return dados[this.topo];
    }

    int vazia(){
        if(this.topo ==-1) {return 1;}
        else{return 0;}
    }

    int cheia() {
        if (this.max == this.topo) {
            return 1;
        }
        else{
            return 0;
        }
    }


}
class Expressao{


}
