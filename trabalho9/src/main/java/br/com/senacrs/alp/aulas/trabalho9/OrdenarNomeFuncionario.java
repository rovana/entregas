package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;


public class OrdenarNomeFuncionario implements Comparator<Funcionario>{
	
	private static Comparator<Funcionario> instancia = new OrdenarNomeFuncionario();
	
	OrdenarNomeFuncionario(){
		super();
	}
	
	public int compare (Funcionario o1, Funcionario o2){
		
		int resultado = 0;
		String nome1;
		String nome2;
		
		nome1 = o1.getNome();
		nome2 = o2.getNome();
		
		resultado = nome1.compareToIgnoreCase(nome2);
		resultado = normalizar(resultado);
		
		return resultado;
	
	}
		private int normalizar(int valor){
		
			int resultado = 0;
			
			if (valor > 0){
				resultado = 1;
			}
			if (valor < 0){
				resultado = -1;
			}
		
			return resultado;
		}
		
		public static Comparator<Funcionario> getInstancia() {
			
			return instancia;
		}	
}
