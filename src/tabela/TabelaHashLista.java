package tabela;

import objeto.Item;

import java.util.ArrayList;
import java.util.Objects;

public class TabelaHashLista implements TabelaInterface{

    private ArrayList<Item>[] tabela;

    private final int CAPACIDADE_DEFAULT = 20;


    public TabelaHashLista() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }


    @Override
    public int hash(String chave) {
        return ((chave.hashCode()&0x7fffffff)% tabela.length);
    }

    @Override
    public boolean cheia() {
        return false;
    }

    @Override
    public void inserir(Item o) {
        int hash = hash(o.getNome());
        ArrayList<Item> items = this.tabela[hash];

        if (items == null){
            items = new ArrayList<Item>();
            items.add(o);
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
    public void dobrarTabela() {

    }
}
