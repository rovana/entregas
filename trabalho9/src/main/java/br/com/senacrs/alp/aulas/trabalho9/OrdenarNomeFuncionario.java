package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class OrdenarNomeFuncionario implements Comparator<Funcionario>{
	
	public int compare (Funcionario o1, Funcionario o2){
		
		int resultado = 0;
		
		resultado = o1.getNome().compareToIgnoreCase(o2.getNome());
		
		if (resultado > 0){
			resultado = 1;
		}
		if (resultado < 0){
			resultado = -1;
		}
		
		return resultado;
	}

}
