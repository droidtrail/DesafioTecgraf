package com.desafioProgramacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class matriculasVerificadas {

	private static final String nomearquivoentrada = "E:\\DesafioProgramacao\\matriculasParaVerificar.txt";
	private static final String NomeArquivoSaida = "E:\\DesafioProgramacao\\matriculasVerificadas.txt";

	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			// Arquivo de Entrada
			fr = new FileReader(nomearquivoentrada);
			br = new BufferedReader(fr);

			// Arquivo de Saída
			fw = new FileWriter(NomeArquivoSaida);
			bw = new BufferedWriter(fw);

			String sCurrentLine = "";
			System.out.println("---------------Início do arquivo---------------");

			while ((sCurrentLine = br.readLine()) != null) {

				if (!sCurrentLine.isEmpty()) {

					String MatrVal = sCurrentLine + " Verdadeiro";

					// Arquivo de Saída
					bw.write(MatrVal);
					bw.newLine();
					System.out.println(MatrVal);
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
				System.out.println(ex);
			}

		}

	}

}
