package br.com.senacrs.alp.aulas.trabalho10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class GerenciadorDeArquivo {

	File arquivo;
	String [] linha = null;


	public GerenciadorDeArquivo(String nomeArquivo) {

		String path = nomeArquivo;

		if (path == null) {
			throw new IllegalArgumentException();
		
		} else {
			arquivo = new File(path);

			if (arquivo.isDirectory()) {
				throw new IllegalArgumentException();
			}
		}
	}

	public String[] lerArquivo() {
	
		BufferedReader input = null;
		
		if (arquivo.isFile()){
			
			try {
				input = new BufferedReader(new FileReader(arquivo));
				linha = leitura(input);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			
			}finally{
				
				try{
					input.close();
					
				}catch (IOException e){
					e.printStackTrace();
				}
		}
			
		}else{
			throw new IllegalArgumentException();
		}
			
		return linha;
	}

	
	
	public String[] leitura(BufferedReader input) {

		LinkedList<String> lista = new LinkedList<String>();

		String line;

		try {

			while ((line = input.readLine()) != null) {
				lista.add(line);
			}

			int tamanho = lista.size();
			linha = new String[tamanho];

			for (int i = 0; i < tamanho; i++) {
				linha[i] = lista.get(i);
			}

		} catch (IOException e) {
			throw new IllegalArgumentException();
		}

		return linha;
	}

	
	public String[] lerArquivoComSubstituicao(String lido, String retornado) {

		String texto[] = lerArquivo();

		for (int i = 0; i < texto.length; i++) {
			texto[i] = texto[i].replace(lido, retornado);
		}
		
		return texto;
	}

	public void escreverArquivo(String[] conteudo) {

		BufferedWriter output = null;

		try {
			output = new BufferedWriter(new FileWriter(arquivo));

			for (int i = 0; i < conteudo.length; i++) {
				output.write(conteudo[i]);
				output.newLine();
				output.flush();
			}

		} catch (IOException e) {
			throw new IllegalArgumentException();

		} finally {

			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
