import objeto.Item;
import tabela.TabelaHashLista;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        TabelaHashLista tabelaHashLista = new TabelaHashLista();


        tabelaHashLista.inserir(new Item("d", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("di", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));


        tabelaHashLista.inserir(new Item("di", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));



        System.out.println(tabelaHashLista.hash("d"));

        System.out.println(tabelaHashLista.buscar("d").toString());

    }






}