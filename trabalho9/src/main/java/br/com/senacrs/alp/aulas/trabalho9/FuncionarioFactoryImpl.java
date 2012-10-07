package br.com.senacrs.alp.aulas.trabalho9;

import br.com.senacrs.alp.aulas.trabalho9.Funcionario;

public class FuncionarioFactoryImpl implements FuncionarioFactory {	
	
	static private FuncionarioFactoryImpl instancia = null;
			

	@Override
	public Funcionario criaFuncionario(String nome, int salario) {
		FuncionarioImp func = null;
		
		if (nome == null){
			throw new IllegalArgumentException();
		}
		if (nome == ""){
			throw new IllegalArgumentException();
		}
		if (salario < 0){
			throw new IllegalArgumentException();
		}
		func = new FuncionarioImp(nome, salario);
		
		return func;
	}
	
	public static FuncionarioFactory getInstancia() {
		
		if (instancia == null){
			instancia = new FuncionarioFactoryImpl();
			
		}
		return instancia;
	}
}
