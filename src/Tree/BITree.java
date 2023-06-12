package Tree;

import org.testng.mustache.Value;

public class BITree<Key extends Comparable<Key>, Value> {

    private class No{

        Key chave;
        Value valor;
        No esquerda;
        No direita;

        public No(Key chave, Value valor) {
            this.chave = chave;
            this.valor = valor;
            esquerda = null;
            direita = null;
        }
    }
    private No raiz;

    public BITree() {
        raiz = null;
    }

    public void inserir(Key chave,Value valor) {
        raiz = inserirRecursivamente(raiz, chave,valor);
    }

    private No inserirRecursivamente(No raiz, Key chave, Value valor) {
        if (raiz == null) {
            raiz = new No(chave,valor);
            return raiz;
        }

        if (chave.compareTo(raiz.chave)<0) {
            raiz.esquerda = inserirRecursivamente(raiz.esquerda, chave, valor);
        } else if (chave.compareTo(raiz.chave)>0) {
            raiz.direita = inserirRecursivamente(raiz.direita, chave, valor);
        }

        return raiz;
    }

    public boolean buscar(Key chave,Value valor) {
        return buscarRecursivamente(raiz, chave ,valor);
    }

    private boolean buscarRecursivamente(No raiz,Key chave ,Value valor) {
        if (raiz == null) {
            return false;
        }

        if (valor == raiz.valor) {
            return true;
        }

        if (chave.compareTo(raiz.chave)<0) {
            return buscarRecursivamente(raiz.esquerda,chave ,valor);
        }

        return buscarRecursivamente(raiz.direita, chave,valor);
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivamente(raiz);
    }

    private void percorrerEmOrdemRecursivamente(No raiz) {
        if (raiz != null) {
            percorrerEmOrdemRecursivamente(raiz.esquerda);
            System.out.println(raiz.valor.toString());
            percorrerEmOrdemRecursivamente(raiz.direita);
        }
    }
}