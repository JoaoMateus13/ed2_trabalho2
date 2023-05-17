package tabela;

import com.sun.jdi.Value;
import objeto.Item;
import java.security.Key;

import static tabela.Status.OCUPADO;
import static tabela.Status.VAZIO;

public class TabelaHashQuadra implements TabelaInterface{


    private Status[] stats;
    private Integer[] chave;
    private Item[] items;

    private int M;


    public TabelaHashQuadra(int tam) {
        this.stats = new Status[tam];
        this.chave = new Integer[tam];
        this.items = new Item[tam];
        this.M = tam;
    }


    @Override
    public int hash(String chave) {


        stats[1] = Status.OCUPADO;

        System.out.println(stats[1].compareTo(OCUPADO));
        return (((chave.hashCode()&0x7fffffff)% M));
    }

    @Override
    public boolean cheia() {
        return false;

    }

    @Override
    public void inserir(Item o) {

    }

    @Override
    public Item buscar(String chave) {
        return null;
    }

    @Override
    public Item buscaAVL(String chave) {
        return null;
    }

    @Override
    public Item buscaTreeB(String chave) {
        return null;
    }

    @Override
    public Item buscaTreeRubro(String chave) {
        return null;

    }

    @Override
    public void resize() {

    }
}
