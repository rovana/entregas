package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class OrderDecrescenteSalarioFuncionario implements Comparator <Funcionario> {
	
	private static Comparator <Funcionario> instancia = new OrderDecrescenteSalarioFuncionario();
	
	OrderDecrescenteSalarioFuncionario(){
		super();
	}
	public int compare(Funcionario o1, Funcionario o2) {

		int resultado = 0;
		int salario1 = 0;
		int salario2 = 0;

		salario1 = o1.getSalario();
		salario2 = o2.getSalario();
		resultado = salario2 - salario1;
		resultado = normalizar(resultado);

		return resultado;
	}

	private int normalizar(int valor) {

		int resultado = 0;

		if (valor > 0) {
			resultado = 1;
		} else if (valor < 0) {
			resultado = -1;
		}

		return resultado;
	}

	public static Comparator<Funcionario> getInstancia() {

		return instancia;
	}

}

