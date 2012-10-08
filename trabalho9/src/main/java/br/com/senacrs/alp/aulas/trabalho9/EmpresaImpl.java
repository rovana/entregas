package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;

import br.com.senacrs.alp.aulas.trabalho9.FuncionarioImp;
import br.com.senacrs.alp.aulas.trabalho9.Funcionario;

public class EmpresaImpl implements Empresa {
	
	private Map<String, Funcionario> funcionarios = null;
	
	private List<Funcionario> listaFuncionario = new LinkedList<Funcionario>();
	public Comparator <Funcionario> OrdenarNomeFuncionario = new OrdenarNomeFuncionario();
	private Comparator <Funcionario> OrderDecrescenteSalarioFuncionario = new OrderDecrescenteSalarioFuncionario();
	private Comparator <Funcionario> OrderCrescenteSalarioFuncionario = new OrderCrescenteSalarioFuncionario();
	
	
	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		
		if (funcionario == null){
			throw new IllegalArgumentException();
		}
		if (funcionario.getNome() == null){
			throw new IllegalArgumentException();
		}
		
	funcionarios.put(funcionario.getNome(), funcionario);
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		
		Funcionario resposta = null;
		resposta = funcionarios.get(nome);
		return resposta;
	}

	@Override
	public int totalFolhaPgto() {
		int totalFolha = 0;
		
		Set<Map.Entry<String, Funcionario>> s = funcionarios.entrySet();
		
		Iterator<Map.Entry<String, Funcionario>> iter = s.iterator();
		
		while(iter.hasNext()){
			Entry<String, Funcionario> ent = iter.next();
			FuncionarioImp FuncionarioTemp = (FuncionarioImp) ent.getValue();
			totalFolha += FuncionarioTemp.getSalario();
			
		}
		return totalFolha;
	}

	@Override
	public List<Funcionario> ordemCrescenteSalario() {
		
		Collections.sort(listaFuncionario, OrderCrescenteSalarioFuncionario);
				
		return listaFuncionario;
	}

	@Override
	public List<Funcionario> ordemDecrescenteSalario() {

		Collections.sort(listaFuncionario, OrderDecrescenteSalarioFuncionario);
		
		return listaFuncionario;
	}

	@Override
	public List<Funcionario> ordemAlfabetica() {
		Collections.sort(listaFuncionario, OrdenarNomeFuncionario);
		
		return listaFuncionario;
	}
	
	

}
