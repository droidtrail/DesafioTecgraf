package com.desafioProgramacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LerEscreverArquivo{

    private static final String nomeArquivoEntrada = "E:\\DesafioProgramacao\\matriculasSemDV.txt";
    private static final String nomeArquivoSaida     = "E:\\DesafioProgramacao\\matriculasComDV.txt";

    public static void main(String[] args) {

        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            // Arquivo de Entrada
            fr = new FileReader(nomeArquivoEntrada);
            br = new BufferedReader(fr);
            
            //Arquivo de Saída
            fw = new FileWriter(nomeArquivoSaida);
            bw = new BufferedWriter(fw);

            String sCurrentLine = "";
            System.out.println("---------------Início do arquivo---------------");

            while ((sCurrentLine = br.readLine()) != null) {

                if (!sCurrentLine.isEmpty()) {

                    int Total = 0;
                    int contador = 5;
                    int resto;

                    for (int i = 0; i < sCurrentLine.length(); i++) {

                        int j = Character.digit(sCurrentLine.charAt(i), 10);

                        Total = Total + (j * contador);
                        contador = contador - 1;
                    }

                    resto = Total / 16;
                    String decimal = Integer.toHexString(resto);
                    String DigitoCod = sCurrentLine + "-" + decimal;

                    // Arquivo de Saída
                    bw.write(DigitoCod);
                    bw.newLine();
                    System.out.println(DigitoCod);
                }
            }

            System.out.println("---------------Fim do arquivo---------------");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}