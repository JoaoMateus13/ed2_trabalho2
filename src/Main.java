import objeto.Item;
import tabela.TabelaHashLista;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        TabelaHashLista tabelaHashLista = new TabelaHashLista(10);


        tabelaHashLista.inserir(new Item("d1", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("d2", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));


        tabelaHashLista.inserir(new Item("d3", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("d4", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("d5", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("d6", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("d7", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("d8", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));

        tabelaHashLista.inserir(new Item("d9", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d10", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d11", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d12", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d13", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d14", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d15", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d16", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));
        tabelaHashLista.inserir(new Item("d17", "str", "dois",
                122, LocalDateTime.now(), LocalDateTime.now()));






/*        System.out.println(tabelaHashLista.hash("d"));

        System.out.println(tabelaHashLista.buscar("d").toString());*/

    }






}