package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ManipulacaoCSV {
    protected String caminho = null;
    protected String linha = null;
    protected List<String> lista;
    protected List<Float> MMAL;
    protected List<Float> MMAI;
    protected List<Float> MMAC;
    protected List<Float> MME;
    protected List<Float> dp;


    public ManipulacaoCSV(String caminho, String linha) {
        setCaminho(caminho);
        setLinha(linha);
        lista = new ArrayList<String>();
        MMAL = new ArrayList<Float>();
        MMAI = new ArrayList<Float>();
        MMAC = new ArrayList<Float>();
        MME = new ArrayList<Float>();
        dp = new ArrayList<Float>();
        ler(5);
        MMA();
        MME();
        DP();
        Salvar();
        //System.out.println("intermediaria: " + MMAI.size() + "Longa: " + MMAL.size() + "curta: " + MMAC.size() + "Exponencial: " + MME.size() + "Desvio: " + dp.size());
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }


    public void ler (int coluna){
        try {
            BufferedReader bf = new BufferedReader(new FileReader(caminho));

            while ((this.linha = bf.readLine()) != null) {
                try {
                    String[] vetor = linha.split(",");
                    this.lista.add(vetor[coluna]);
                } catch (NumberFormatException e1) {
                    // somente não insere
                }
            }
            bf.close();
        }
        catch (IOException e) {
            System.out.println( "erro não tratado - somente indicação ");
        }
    }

    public void MMA(){
        List<Float> lista2 = new ArrayList<Float>();

        for (int i = 0; i < lista.size(); i++) {

            lista2.add(Float.valueOf(lista.get(i)));
        }

        for (int i = 0; i < lista2.size()-4; i++){
            this.MMAI.add ((lista2.get(i) + lista2.get(i+1) + lista2.get(i+2) + lista2.get(i+3) + lista2.get(i+4))/5);
        }
        for (int i = 0; i < lista2.size()-9; i++){
            this.MMAL.add ((lista2.get(i) + lista2.get(i+1) + lista2.get(i+2) + lista2.get(i+3) + lista2.get(i+4)
            + lista2.get(i+5) + lista2.get(i+6) + lista2.get(i+7) + lista2.get(i+8) + lista2.get(i+9))/9);
        }
        for (int i = 0; i < lista2.size()-2; i++){
            this.MMAC.add ((lista2.get(i) + lista2.get(i+1))/5);
        }
    }

    public void MME(){
        List<Float> lista2 = new ArrayList<Float>();
        float mult = 0;
        mult = (float) 0.33;

        for (int i = 0; i < lista.size(); i++) {

            lista2.add(Float.valueOf(lista.get(i)));
        }
        for (int i = 0; i < lista2.size(); i++){
            if (i > 0) {
                this.MME.add(((lista2.get(i)-MME.get(i-1))*mult)+MME.get(i-1));
            }
            else {
                this.MME.add(MMAI.get(i));
            }
        }
    }

    public void DP(){
        List<Float> lista2 = new ArrayList<Float>();
        List<Float> aux = new ArrayList<Float>();

        for (int i = 0; i < lista.size(); i++) {

            lista2.add(Float.valueOf(lista.get(i)));
        }
        for (int i = 0; i < MMAI.size(); i++) {
            float aux1, aux2, aux3, aux4,aux5;
            aux1= ((lista2.get(i)-MMAI.get(i))*(lista2.get(i)-MMAI.get(i)));
            aux2= ((lista2.get(i+1)-MMAI.get(i))*(lista2.get(i+1)-MMAI.get(i)));
            aux3= ((lista2.get(i+2)-MMAI.get(i))*(lista2.get(i+2)-MMAI.get(i)));
            aux4= ((lista2.get(i+3)-MMAI.get(i))*(lista2.get(i+3)-MMAI.get(i)));
            aux5= ((lista2.get(i+4)-MMAI.get(i))*(lista2.get(i+4)-MMAI.get(i)));
            this.dp.add((float) Math.sqrt(((aux1+aux2+aux3+aux4+aux5)/5)));
        }

    }
    public void Salvar(){
        EscreverCSV Arquivo = new EscreverCSV("C:\\Users\\leoda\\OneDrive\\Área de Trabalho\\Trabalho\\Saida.csv");
        Arquivo.Escrever(lista,MMAI,MMAL,MMAC,MME,dp);

    }

}

