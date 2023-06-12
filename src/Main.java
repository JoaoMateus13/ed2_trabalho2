import Tree.AVLTree;
import Tree.BITree;
import Tree.RBTree;
import leitor.Leitor;
import objeto.Item;
import objeto.objOrdem;
import tabela.LinearProbingHashST;
import tabela.Status;
import tabela.TabelaHashLista;
import tabela.TabelaHashQuadra;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static tabela.Status.OCUPADO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");



        TabelaHashLista tabelaHashLista = new TabelaHashLista(10);
        TabelaHashQuadra tabelaHashQuadra = new TabelaHashQuadra(10);
        AVLTree avlTree = new AVLTree();
        BITree biTree = new BITree();
        RBTree rbTree = new RBTree();
        Scanner scanner = new Scanner(System.in);




        Leitor leitor = new Leitor();
        leitor.leitor("C:\\Users\\joaom\\OneDrive" +
                "\\Área de Trabalho\\TRABALHO FERIAS\\" +
                "ed2_trabalho2\\src\\leitor\\teste.csv");


        ArrayList<Item> itens = leitor.getItens();


        double valorBuscarQuadra = 0;
        double valorInserirQuadra = 0;
        double valorBuscarLista = 0;
        double valorInserirLista = 0;


        objOrdem ordernarTipo = objOrdem.PORTIPO;
        Object ordernarDataCriacao = null;
        Object ordernarDataModificacao = null;
        Object ordernarTamanho = null;

         //Tentativa Quadrática
        //É REALIZADA 100 x (100.000 INSERÇÕES E 10.000 BUSCAS),
        // SENDO ADICIONADAS NAS VARIAVES E DEPOIS TIRADA A MÉDIA
        for (int i = 0; i < 100; i++) {


            //INSERÇÃO
            double startTimeLista1 = System.nanoTime();
            for (int j = 0; j < 100000; j++) {
                tabelaHashLista.inserir(itens.get(j));
            }
            double elapsedTimeLista1 = (System.nanoTime()-startTimeLista1)/1000000;
            valorInserirLista += elapsedTimeLista1;

            //BUSCA
            double startTimeLista = System.nanoTime();
            for (int j = 0; j < 10000; j++) {
                tabelaHashLista.buscar(itens.get((int) (Math.random() * 10000)).getNome());
            }
            double elapsedTimeLista = (System.nanoTime()-startTimeLista)/1000000;
            valorBuscarLista += elapsedTimeLista;

        }
        System.out.println("------------------RESULTADOS LISTA---------------------");
        System.out.println("Inserir lISTA: " + valorInserirLista/100 + "/ Busca LISTA: " + valorBuscarLista/100);



        //Encadeamento externo usando Lista
        //É REALIZADA 100 x (100.000 INSERÇÕES E 10.000 BUSCAS),
        // SENDO ADICIONADAS NAS VARIAVES E DEPOIS TIRADA A MÉDIA
       for (int i = 0; i < 100; i++) {

            double startTimeQuadra1 = System.nanoTime();
            for (int j = 0; j < 100000; j++) {
                tabelaHashQuadra.inserir(itens.get(j));
            }
            double elapsedTimeQuadra1 = (System.nanoTime() - startTimeQuadra1) / 1000000;

            valorInserirQuadra += elapsedTimeQuadra1;


            double startTimeQuadra = System.nanoTime();
            for (int j = 0; j < 10000; j++) {
                tabelaHashQuadra.buscar(itens.get((int) (Math.random() * 10000)).getNome());
            }
            double elapsedTimeQuadra = (System.nanoTime() - startTimeQuadra) / 1000000;
            valorBuscarQuadra += elapsedTimeQuadra;;
        }
        System.out.println("\n------------------RESULTADOS QUADRATICA---------------------");
        System.out.println("Inserir Quadratica: " + valorInserirQuadra/100 + "/ Busca Quadratica: " + valorBuscarQuadra/100);



        int op = 0;

        System.out.println("\n1 - ORDENAR POR NOME\n2 - ORDENAR POR TIPO\n3 - ORDENAR POR DATA DE MOTIFICACAO" +
                "\n4 - ORDENAR POR DATA DE CRIACAO\n5 - ORDENAR POR TAMANHO");

        op = scanner.nextInt()-1;


        //INSERINDO NA ARVORE COM LISTA

        double startTimeRBLista = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            rbTree.insere(tabelaHashLista.buscar(itens.get(i).getNome()).retornarChave(objOrdem.values()[op]),
                            tabelaHashLista.buscar(itens.get(i).getNome()));
        }
        double elapsedTimeRBLista = (System.nanoTime()-startTimeRBLista)/1000000;
        //rbTree.view();



        double startTimeBILista = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            biTree.inserir(tabelaHashLista.buscar(itens.get(i).getNome()).retornarChave(objOrdem.values()[op]),
                    tabelaHashLista.buscar(itens.get(i).getNome()));
        }
        double elapsedTimeBILista = (System.nanoTime()-startTimeBILista)/1000000;
    //    biTree.percorrerEmOrdem();




        double startTimeAvlLista = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            avlTree.put(tabelaHashLista.buscar(itens.get(i).getNome()).retornarChave(objOrdem.values()[op]),
                    tabelaHashLista.buscar(itens.get(i).getNome()));
        }
        double elapsedTimeAvlLista = (System.nanoTime()-startTimeAvlLista)/1000000;
        //avlTree.view();

        System.out.println("\n------------------RESULTADOS ARVORE COM LISTA---------------------");
        System.out.println("RB: " + elapsedTimeRBLista + "  " + "BI: " + elapsedTimeBILista + "  "  +"AVL: " + elapsedTimeAvlLista);



        //INSERINDO NA ARVORE COM QUADRATICA

        double startTimeRBQUA = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            rbTree.insere(tabelaHashQuadra.buscar(itens.get(i).getNome()).retornarChave(objOrdem.values()[op]),
                    tabelaHashQuadra.buscar(itens.get(i).getNome()));
        }
        double elapsedTimeRBQUA = (System.nanoTime()-startTimeRBQUA)/1000000;
        //rbTree.view();




        double startTimeBIQUA = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            biTree.inserir(tabelaHashQuadra.buscar(itens.get(i).getNome()).retornarChave(objOrdem.values()[op]),
                    tabelaHashQuadra.buscar(itens.get(i).getNome()));
        }
        double elapsedTimeBIQUA = (System.nanoTime()-startTimeBIQUA)/1000000;
        //    biTree.percorrerEmOrdem();


        double startTimeAVLQUA = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            avlTree.put(tabelaHashQuadra.buscar(itens.get(i).getNome()).retornarChave(objOrdem.values()[op]),
                    tabelaHashQuadra.buscar(itens.get(i).getNome()));
        }
        double elapsedTimeAVLQUA  = (System.nanoTime()-startTimeAVLQUA )/1000000;
        //avlTree.view();



        System.out.println("------------------RESULTADOS ARVORE COM QUADRATICA---------------------");
        System.out.println("RB: " + elapsedTimeRBQUA + "  " + "BI: " + elapsedTimeBIQUA + "  "  +"AVL: " + elapsedTimeAVLQUA);


    }






}