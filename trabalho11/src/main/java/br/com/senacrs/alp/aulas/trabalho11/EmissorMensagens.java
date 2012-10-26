package br.com.senacrs.alp.aulas.trabalho11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmissorMensagens {
	
	File arquivo;
	
	Map<String, String> mapa = new HashMap<String, String>();
	
	
	public EmissorMensagens(String nomeArquivo) {
	
		if (nomeArquivo == null) {
			throw new IllegalArgumentException();
			
		} 
		else {
			arquivo = new File(nomeArquivo);

			if (arquivo.isDirectory()) {
				throw new IllegalArgumentException();
			}
			if (!arquivo.exists()){
				throw new IllegalArgumentException();
				
			}
		}
	}
	
	
	public String formatarMensagem(String chave, Object... argumentos) {

		String msg;
		String mapaChave;
		
		mapaChave = mapa.get(chave);
				
		if (mapaChave == null){
			throw new IllegalArgumentException("Não há chave válida");
		}	
		
		msg = String.format(chave, argumentos);
		
		return msg;
	}
	
	public int importarMensagem(){
		
		BufferedReader input = null;
		String linha = null;
		int resp = 0;	
		
		try {
			input = new BufferedReader(new FileReader(arquivo));
				
			while(linha!=null){
				if (linhaValida(linha)!=0){
					resp = linhaValida(linha);
					break;
				}
				try {
					linha = input.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally{
					try{
						input.close();
						
					}catch (IOException e){
						e.printStackTrace();
					}
				}
				}
			}catch (IOException e){
				e.printStackTrace();
			}
				return resp;
	}

	public int linhaValida(String linha){
		
		
		return 0;
		
	}
}
