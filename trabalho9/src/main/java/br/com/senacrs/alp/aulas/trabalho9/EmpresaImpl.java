package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import br.com.senacrs.alp.aulas.trabalho9.Funcionario;

public class EmpresaImpl implements Empresa {
	
	private Map<String, Funcionario> funcionarios = null;
	

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
		
		LinkedList<Funcionario> lista = null;
		lista = new LinkedList<Funcionario>(funcionarios.values());
		OrdenarSalarioFuncionario compara = null;
		compara = OrdenarSalarioFuncionario();
		Collections.sort(lista, compara);
				
		return lista;
	}

	@Override
	public List<Funcionario> ordemDecrescenteSalario() {

		LinkedList<Funcionario> lista = null;
		lista = new LinkedList<Funcionario>(funcionarios.values());
		OrdenarSalarioFuncionario compara = null;
		compara = OrdenarSalarioFuncionario();
		compara = setOrdenar(1);
		Collections.sort(lista, compara);
		
		return lista;
	}

	@Override
	public List<Funcionario> ordemAlfabetica() {
		LinkedList<Funcionario> lista = null;
		lista = new LinkedList<Funcionario>(funcionarios.values());
		OrdenarFuncionarioNome compara = null;
		compara = OrdenarSalarioFuncionario();
		Collections.sort(lista,compara);
		return lista;
	}
	
	

}
