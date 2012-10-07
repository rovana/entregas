package br.com.senacrs.alp.aulas.trabalho9;

public class FuncionarioImp implements Funcionario{
	private String nome = null;
	private int salario = 0;
	
	public FuncionarioImp(String nome, int salario){
		this.nome = nome;
		this.salario = salario;
		
	}
	public String getNome(){
		return this.nome;
		
	}
	public int getSalario(){
		return this.salario;
	}

}