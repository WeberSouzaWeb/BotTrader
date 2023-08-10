package org.example;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class EscreverCSV {

    protected String caminho = null;
    public EscreverCSV(String caminho) {
        setCaminho(caminho);
    }
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    public String getCaminho() {
        return caminho;
    }
    public void Escrever(List <String> lista2,List <Float> MMAI, List <Float> MMAL, List <Float> MMAC, List <Float> MME, List <Float>  DP) {
        try {
            System.out.println("Gerando Arquivo CSV");
            FileWriter fw = new FileWriter(new File(getCaminho()));
            CSVWriter cw = new CSVWriter(fw);
            String[] cabecalho = {"MMAL","MMAI","MMAC", "MME", "DP"};
            String[] data;
            List<String[]> lista = new ArrayList<String[]>();
            lista.add(cabecalho);

            for (int i = 0; i < lista2.size(); i++) {
                if (i < MMAL.size()) {

                    data = new String[]{String.valueOf(MMAL.get(i)),String.valueOf(MMAI.get(i)),String.valueOf(MMAC.get(i)), String.valueOf(MME.get(i)), String.valueOf(DP.get(i))};
                    lista.add(data);
                } else {
                    if (i < MMAI.size()){
                        data = new String[]{"NULL",String.valueOf(MMAI.get(i)),String.valueOf(MMAC.get(i)), String.valueOf(MME.get(i)), String.valueOf(DP.get(i))};
                        lista.add(data);
                    }
                    else {
                        if (i < MMAC.size()){
                            data = new String[]{"NULL","NULL",String.valueOf(MMAC.get(i)), String.valueOf(MME.get(i)), "NULL"};
                            lista.add(data);
                        }
                        else {
                            data = new String[]{"NULL","NULL","NULL", String.valueOf(MME.get(i)), "NULL"};
                            lista.add(data);
                        }
                    }

                }
            }
            cw.writeAll((Iterable<String[]>) lista);
            cw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
