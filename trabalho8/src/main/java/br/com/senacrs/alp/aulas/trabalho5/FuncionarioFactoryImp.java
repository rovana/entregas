package br.com.senacrs.alp.aulas.trabalho5;

public class FuncionarioFactoryImp implements FuncionarioFactory{
	
	private Funcionario funcionario = null;
	
	private static FuncionarioFactoryImp instancia = new FuncionarioFactoryImp();
	
	public Funcionario criaFuncionario (String nome, int salario){
		
		if (nome == null){
			throw new IllegalArgumentException();
		}
		
		if (nome.equals("")){
			throw new IllegalArgumentException();
		}
		
		if (salario < 0){
			throw new IllegalArgumentException();
		}
		
		funcionario = new FuncionarioImp (nome, salario);
		
		return funcionario;
	}
	
	public static FuncionarioFactoryImp getInstancia(){
		
		return FuncionarioFactoryImp.instancia;
	}
}
