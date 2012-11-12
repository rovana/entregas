package br.com.senacrs.alp.aulas.trabalho12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Arquivo {
	
	private File file;
	private String path;
	private String[] linha = null;
	private String requisicao;
	
	public File getArquivo(){
		return file;
	}
	
	public File setArquivo(File file){
		return file;
	}
	
	public Arquivo(String nomeArquivo) {

		String path = nomeArquivo;
		
		if (path == null) {
			throw new IllegalArgumentException();
		} else {
			
			file = new File(path);
			
			if (file.isDirectory() || !file.exists()) {
				throw new IllegalArgumentException();
			}		
		}
	}

	public String[] lerArquivo() {
		
		BufferedReader input = null;
		
		if (file.isFile()) {
			
			try {
				
				input = new BufferedReader(new FileReader(file));
				linha = leitura(input);
							
			} catch (FileNotFoundException e) {	
				throw new IllegalArgumentException();
			
			} finally {
					
				try {		
					input.close();
				} catch (IOException e) {
					throw new IllegalArgumentException();
				}
			}
			
		} else {
			throw new IllegalArgumentException();
		}

		return linha;
	}
	
	private String[] leitura(BufferedReader input) {
		
		List<String> lista = new LinkedList<String>();
		
		String line;
		
		try {
			
			while ((line = input.readLine()) != null) {
				lista.add(line);
			}
						
			int tamanho = lista.size();
			
			linha = new String[tamanho];
			
			for (int i = 0; i<tamanho; i++) {
				linha[i] = lista.get(i);
			}
				
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}
		
		return linha;
		
	}
	
	public String organizarRootDir(String root_dir) {
	
		if (!root_dir.startsWith("./")) {
			System.out.println("ERRO");
			throw new IllegalArgumentException();			
		}
				
		String substituir = null;
		String substituicao = null;
						
		substituir = "./";
		substituicao = System.getProperty("user.dir") + File.separatorChar;
		root_dir = root_dir.replace(substituir, substituicao);
			
		substituir = "/";
		substituicao = ""+File.separatorChar;
		root_dir = root_dir.replace(substituir, substituicao);
		
		return root_dir;
		
	}
	
	public int organizarPorta (String portaArg) {
		
		int porta = 0;
		
		try {
			porta = Integer.parseInt(portaArg);
		} catch (Exception e) {
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		return porta;
	}
	
	public String getRequisicao() {
		return requisicao;
	}
	
	public void setRequisicao(String requisicao) {
		this.requisicao = requisicao;
	}
	

}
