package tabela;

import objeto.Item;

public interface TabelaInterface {


    public int hash(String chave);


    public boolean cheia();


    public void inserir(Item o);


    public Item buscar(String chave);

    public Item buscaAVL(String chave);

    public Item buscaTreeB(String chave);

    public Item buscaTreeRubro(String chave);


    public void resize();

}
