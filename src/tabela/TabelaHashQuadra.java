package tabela;

import com.sun.jdi.Value;
import objeto.Item;
import java.security.Key;
import java.security.SignedObject;

import static tabela.Status.OCUPADO;
import static tabela.Status.VAZIO;

public class TabelaHashQuadra implements TabelaInterface{


    private Status[] stats;
    private Object[] chave;
    private Item[] itens;

    private int M;

    int size;


    public TabelaHashQuadra(int tam) {
        this.stats = new Status[tam];
        this.chave = new Object[tam];
        this.itens = new Item[tam];
        this.M = tam;
    }


    @Override
    public int hash(String chave) {

        return (((chave.hashCode()&0x7fffffff)% M));
    }


    public int hashQuadratica(String chave, int i){
        int hashQuadratica = ((hash(chave)) + 2*i + 5*i*i)%M;
        return hashQuadratica;
    }

    @Override
    public boolean cheia() {
        return false;

    }

    @Override
    public void inserir(Item o) {
        int i;
        int k = 0;
        int hashQ;
       // if (size >= M/2)
         //   resize(2*M); // double M

        for (i=0,hashQ = 0; chave[hashQ] != null;
             i++,hashQ =hashQuadratica(o.getNome(),i))

        if(chave[hashQ] != null)
            if (chave[hashQ].equals(o.getNome())) {
                itens[hashQ] = o;
                return;
            }
        //Achou uma posição livre
        chave[hashQ] = o.getNome();
        itens[hashQ] = o;
        stats[hashQ] = OCUPADO;
        size++;
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
