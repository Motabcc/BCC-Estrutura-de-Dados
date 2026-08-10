import java.util.Scanner;

public class Pilha {
    public char[] dados;
    public int topo;
    public int max;

    //Builder Pilha
    public Pilha(int n){
        this.topo=-1;
        this.max=n;
        this.dados= new char[n];
    }
    public int cheia(){
        if( this.topo==this.max-1){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int vazia(){
        if( this.topo==-1){
            return 1;
        }
        else{
            return 0;
        }
    }
    public char topo(){
        return this.dados[this.topo];
    }

    public void empilha(int info){
        if (cheia()==0) {
            this.topo++;
            this.dados[this.topo] = (char) info;
        }
        else{
            System.out.println("A pilha está cheia");
        }
    }
    public char desempilha(){
        if(vazia()==0){
            char valorRemovido = this.dados[this.topo];
            this.topo--;
            return valorRemovido;
        }
        else{
            System.out.println("A pilha está vazia");
            return '\0';
        }
    }

}
class  Expressao{
    public int verificar(String texto){

        Pilha pilhaTeste= new Pilha(texto.length()) ;

        // só add quem abre.
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            if((letra == '(') || (letra == '{') || (letra == '[')  ){
                pilhaTeste.empilha(letra);
            }
            else if (letra == ')' || letra == '}' || letra == ']') {
                if(pilhaTeste.vazia()==1){
                return 0;
                }
                char topoAtual = pilhaTeste.topo();
                if(        (letra == ')'&& topoAtual=='(')
                        || (letra == '}' && topoAtual == '{')
                        || (letra == ']' && topoAtual == '[')){
                    pilhaTeste.desempilha();
                }
                else{
                    return 0;
                }
            }
        }
        if (pilhaTeste.vazia()==1) {
            return 1;
        } else {
            return 0;
        }
    }

    static void main(String[] args) {
        Expressao exp = new Expressao();
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite sua Equação: ");
        String resposta = teclado.nextLine();

        System.out.println("Seu resultado é: " + exp.verificar(resposta));
    }
}








