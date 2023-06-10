package leitor;

import objeto.Item;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Leitor {
    static int tamm = 0;

    static int error = 0;

   static ArrayList<Item> itens = new ArrayList<>();

    public ArrayList<Item> getItens() {
        return itens;
    }

    public int getTamm() {
        return tamm;
    }

    public int getError(){
        return error;
    }


    public void leitor(String arquivo){

        String line = "";
        String csvDelimiter = ",";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        int conte = 0;
        int tam = 0;




        //Verificação da quantidade dos objetos
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo)) ) {
           while ((line = br.readLine()) != null) {
               try {
                   String[] data = line.split(csvDelimiter);

                   //Atributos do objeto
                   String nome = data[0];
                   String caminho = data[1];
                   String tipo = data[2];
                   double tamanho = Double.parseDouble(data[3]);
                   Date dataCriacao = dateFormat.parse(data[4]);
                   Date dataModificacao = dateFormat.parse(data[5]);

                   Item item = new Item(nome, caminho, tipo, tamanho, dataCriacao, dataModificacao);
                   if (itens.add(item)) {
                       tamm++;
                   }

               } catch (Exception e) {
                   error++;
                   continue;
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
