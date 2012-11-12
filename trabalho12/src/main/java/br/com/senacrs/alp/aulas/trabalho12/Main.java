package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;
import java.util.Arrays;

public class Main {
	
	private final static String DIRETORIOARQUIVO = System.getProperty("user.dir")
			+ File.separatorChar
			+ "diretorio"
			+ File.separatorChar;
	private File root_dir = null;

	public static void main(String[] args) {
		
		if (args == null || args.length == 0) {
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		String argumentos = null;
		argumentos = Arrays.toString(args);
		argumentos = argumentos.replaceAll("\\[","").replaceAll("\\]","");
		String[] argumentosSeparados = argumentos.split(",");
		
		String arquivoConfiguracao = null;
		arquivoConfiguracao = argumentosSeparados[0];
		arquivoConfiguracao = DIRETORIOARQUIVO + arquivoConfiguracao;
		
		
		Arquivo gerenciadorArquivo = new Arquivo(arquivoConfiguracao);
		String[] linhasArquivo = gerenciadorArquivo.lerArquivo();
		
		String separador = "=";
		String[] linhaSeparada = null;
		String root_dir = null;
		int porta = 0;

		for (int i = 0; i<linhasArquivo.length; i++) {
			
			if (linhasArquivo[i].matches(".*\\=.*")) {
				linhaSeparada = linhasArquivo[i].split(separador, 2);
			} else {
				System.out.println("ERRO");
				System.exit(0);
			}
			
			//Primeira linha do arquivo
			if(i == 0) {
				root_dir = linhaSeparada[1].trim();	
				
				root_dir = gerenciadorArquivo.organizarRootDir(root_dir);	
			} 
			
			//Segunda linha do arquivo
			if(i == 1) {	
				String portaString = linhaSeparada[1].trim();
				porta = gerenciadorArquivo.organizarPorta(portaString);
			}
		}
	
		System.out.println(porta + ":" + root_dir);
		
	}
	
	public String getRoot_dir() {
		return root_dir.toString();
	}
}
