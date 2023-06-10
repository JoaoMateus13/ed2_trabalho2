import Tree.AVLTree;
import Tree.BITree;
import Tree.RBTree;
import leitor.Leitor;
import objeto.Item;
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
        Scanner scanner = new Scanner(System.in);



        Leitor leitor = new Leitor();
        leitor.leitor("C:\\Users\\joaom\\OneDrive\\Área de Trabalho\\TRABALHO FERIAS\\ed2_trabalho2\\src\\leitor\\teste.csv");

        ArrayList<Item> items = leitor.getItens();

        double valorBuscarQuadra = 0;
        double valorInserirQuadra = 0;
        double valorBuscarLista = 0;
        double valorInserirLista = 0;

        for (int i = 0; i < 100; i++) {


/*        System.out.println("-------------" + "Inserir Lista" + "----------");
        scanner.nextInt();*/

            double startTimeLista1 = System.nanoTime();
            for (int j = 0; j < 100000; j++) {
                tabelaHashLista.inserir(items.get(j));
            }
            double elapsedTimeLista1 = (System.nanoTime()-startTimeLista1)/1000000;
            valorInserirLista += elapsedTimeLista1;

    /*    System.out.println(elapsedTimeLista1);

        System.out.println("-------------" + "Busca Lista" + "----------");
        scanner.nextInt();*/

            double startTimeLista = System.nanoTime();
            for (int j = 0; j < 10000; j++) {
                tabelaHashLista.buscar(items.get((int) (Math.random() * 10000)).getNome());
            }
            double elapsedTimeLista = (System.nanoTime()-startTimeLista)/1000000;
            valorBuscarLista += elapsedTimeLista;

            //    System.out.println(elapsedTimeLista);

        }
        System.out.println("------------------RESULTADOS---------------------");
        //buscar
        //       System.out.println("Busca Lista: " + elapsedTimeLista + "/ Busca Quadratica: " + elapsedTimeQuadra);
        //inserir
        //       System.out.println("Inserir Lista: " + elapsedTimeLista1 + "/1 Inserir Quadratica " + elapsedTimeQuadra1);

        System.out.println("Inserir lISTA: " + valorInserirLista/100 + "/ Busca LISTA: " + valorBuscarLista/100);
        //      System.out.println(leitor.getItens());

        for (int i = 0; i < 100; i++) {


        /*    System.out.println("-------------" + "Inserir quadratica" + "----------");
            scanner.nextInt();*/

            double startTimeQuadra1 = System.nanoTime();
            for (int j = 0; j < 100000; j++) {
                tabelaHashQuadra.inserir(items.get(j));
            }
            double elapsedTimeQuadra1 = (System.nanoTime() - startTimeQuadra1) / 1000000;

            valorInserirQuadra += elapsedTimeQuadra1;
    /*        System.out.println(elapsedTimeQuadra1);

            System.out.println("-----------------------------------------------------------------------------");


            System.out.println("-------------" + "Busca quadratica" + "----------");
            scanner.nextInt();*/


            double startTimeQuadra = System.nanoTime();
            for (int j = 0; j < 10000; j++) {
                tabelaHashQuadra.buscar(items.get((int) (Math.random() * 10000)).getNome());
            }
            double elapsedTimeQuadra = (System.nanoTime() - startTimeQuadra) / 1000000;
            valorBuscarQuadra += elapsedTimeQuadra;

            //        System.out.println(elapsedTimeQuadra);
        }
        System.out.println("------------------RESULTADOS---------------------");
        //buscar
        //       System.out.println("Busca Lista: " + elapsedTimeLista + "/ Busca Quadratica: " + elapsedTimeQuadra);
        //inserir
        //       System.out.println("Inserir Lista: " + elapsedTimeLista1 + "/1 Inserir Quadratica " + elapsedTimeQuadra1);

        System.out.println("Inserir Quadratica: " + valorInserirQuadra/100 + "/ Busca Quadratica: " + valorBuscarQuadra/100);
        //      System.out.println(leitor.getItens());


        ////////LISTA

        AVLTree avlTree = new AVLTree();
        BITree biTree = new BITree();
        RBTree rbTree = new RBTree();



/*        double startTimeHeap = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            rbTree.insere(leitor.getItens().get(i).getNome().toLowerCase(), leitor.getItens().get(i));
        }
        double elapsedTimeHeap = (System.nanoTime()-startTimeHeap)/1000000;

        rbTree.view();*/


/*

        double startTimeHeap1 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            biTree.inserir(leitor.getItens().get(i).getNome().toLowerCase(), leitor.getItens().get(i));
        }
        double elapsedTimeHeap1 = (System.nanoTime()-startTimeHeap1)/1000000;

        biTree.percorrerEmOrdem();
*/

/*

        double startTimeHeap2 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            avlTree.put(leitor.getItens().get(i).getNome().toLowerCase(), leitor.getItens().get(i));
        }
        double elapsedTimeHeap2 = (System.nanoTime()-startTimeHeap2)/1000000;
*/


   //     System.out.println(elapsedTimeHeap + "  " + elapsedTimeHeap1 + "  "  +elapsedTimeHeap2);

    }






}