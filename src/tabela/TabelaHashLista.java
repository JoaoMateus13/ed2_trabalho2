package tabela;

import objeto.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class TabelaHashLista implements TabelaInterface{

    private ArrayList<Item>[] tabela;
    private int size;
    private int M;
    private final int CAPACIDADE_DEFAULT = 20;


   public TabelaHashLista() {
        this.tabela = new ArrayList[M];
    }

    public TabelaHashLista(int capacidade) {
        this.tabela = new ArrayList[capacidade];
        this.M = this.tabela.length;
    }

    @Override
    public int hash(String chave) {
        return ((chave.hashCode()&0x7fffffff)% tabela.length);
    }



    @Override
    public boolean cheia() {
        return false;
    }

    public void resize() {


     //   if (this.size / this.tabela.length >= 0.75 || this.size == this.tabela.length){

            TabelaHashLista novaTabela;

            novaTabela = new TabelaHashLista(this.tabela.length*2);



            for(int i = 0; i<M; i++){
                ArrayList<Item> items = this.tabela[i];
                if (items!=null) {
                    for (int j = 0; j < items.size(); j++) {
                            novaTabela.inserir(items.get(j));
                        }
                    }
                }
      //      }
        this.M = novaTabela.M;
        this.size = novaTabela.size;
        this.tabela  = novaTabela.tabela;
    }




    @Override
    public void inserir(Item o) {
        int hash = hash(o.getNome());
        ArrayList<Item> items = this.tabela[hash];

        if (items == null){
            items = new ArrayList<Item>();
            items.add(o);
            size++;
            this.tabela[hash] = items;
        }
        else {
            for(int i = 0; i<items.size(); i++){
                if(Objects.equals(items.get(i).getNome(), o.getNome())){
                    items.set(i, o); //atualiza o item
                    return;
                }
            }
            items.add(o);
            size++;
        }
        if(this.size/M >= 0.75){
            resize();
        }
    }

    @Override
    public Item buscar(String chave) {
        int hash = hash(chave);
        ArrayList<Item> items = this.tabela[hash];

        if (items == null)
            return null;

        for (Item item : items) {
            if (item.getNome().equals(chave))
                return item;
        }

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

}
