package br.com.senacrs.alp.aulas.trabalho5;

import java.util.HashMap;
import java.util.Map;

public class EmpresaImp implements Empresa{
	Map<String, Funcionario> mapFuncionario = new HashMap <String, Funcionario>();
	
	public void adicionaFuncionario (Funcionario funcionario){
		
		String nome = null;
		
		if (funcionario == null){
			throw new IllegalArgumentException ("Funcionário é null");
		}
		nome = funcionario.getNome();
		
		if (funcionario.getNome() != null){
			mapFuncionario.put(nome, funcionario);
		}
	}
	
	public Funcionario buscaFuncionario (String nome){
		Funcionario resultado = null;
		
		resultado = mapFuncionario.get(nome);
		
		return resultado;
	}
	
	public int totalFolhaPagamento(){
		int salario = 0;
		
		for (Funcionario f: mapFuncionario.values()){
			salario = salario + f.getSalario();
		}
		return salario;
	}
	


}
