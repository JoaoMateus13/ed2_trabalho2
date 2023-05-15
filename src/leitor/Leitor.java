package leitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leitor {
    public void leitor(String arquivo){

        String line = "";
        String csvDelimiter = ",";
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm");
        int conte = 0;
        int tam = 0;



        //Verificação da quantidade dos objetos
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo)) ) {
            while ((line = br.readLine()) != null) {
                tam++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Definição do tam dos vetores


        try (BufferedReader br = new BufferedReader(new FileReader(arquivo)) ) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvDelimiter);


                //Atributos do objeto
                String nome = data[0];
                String caminho = data[1];
                String tipo = data[2];
                double tamanho = Double.parseDouble(data[3]);
                Date dataCriacao = dateFormat.parse(data[4]);
                Date dataModificacao = dateFormat.parse(data[5]);


                //Criação do objeto



                //


                conte++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
        }

    }

}
