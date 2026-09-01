package tde2;

public class Main {
    public static void main(String[] args) {

        ListaEncadeada listaX = new ListaEncadeada();
        ListaEncadeada listaY = new ListaEncadeada();

        listaX.insere_ultimo(1);
        listaX.insere_ultimo(2);
        listaX.insere_ultimo(3);

        listaY.insere_ultimo(1);
        listaY.insere_ultimo(2);
        listaY.insere_ultimo(3);

        double resultado = listaX.similaridade(listaY);
        System.out.println("Similaridade do Cosseno: " + resultado);
        System.out.println();

        ListaEncadeada listaA = new ListaEncadeada();
        ListaEncadeada listaB = new ListaEncadeada();

        listaA.insere_ultimo(9);
        listaA.insere_ultimo(2);
        listaA.insere_ultimo(5);
        listaA.insere_ultimo(7);

        listaB.insere_ultimo(7);
        listaB.insere_ultimo(1);
        listaB.insere_ultimo(5);
        listaB.insere_ultimo(3);

        System.out.println("Elementos em comum ordenados:");
        ListaEncadeada listaZ = listaA.intersecao(listaB);

        if (listaZ.vazia()) {
            System.out.println("Nenhum elemento em comum.");
        } else {
            listaZ.mostra_lista();
        }
    }
}