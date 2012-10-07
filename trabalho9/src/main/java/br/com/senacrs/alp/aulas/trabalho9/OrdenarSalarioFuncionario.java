package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class OrdenarSalarioFuncionario implements Comparator<Funcionario> {
	
	private int ordenar;
	
	public OrdenarSalarioFuncionario(){
		ordenar = 0;
	}
	
	public int compare (Funcionario o1, Funcionario o2){
		int resultado = 0;
		
		resultado = o1.getSalario() - o2.getSalario();
		
		if (ordenar == 0){
			if (resultado < 0){
				resultado = 1;
			}
			if (resultado > 0){
				resultado = -1;
			}
			
		}else {
			if (resultado < 0 ){
				resultado = -1;
			}
			if (resultado > 0){
				resultado = 1;
			}
		}
		return resultado;
	}
	
	public int getOrdenar(){
		return ordenar;
	}
	public void setOrdenar (int ordenar){
		this.ordenar = ordenar;
	}

}
