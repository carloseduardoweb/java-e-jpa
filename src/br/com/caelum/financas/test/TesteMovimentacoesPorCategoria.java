package br.com.caelum.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.model.Categoria;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.util.Transaction;

public class TesteMovimentacoesPorCategoria extends Transaction {

	public static void main(String[] args) {
		new TesteMovimentacoesPorCategoria().executeTransaction();
	}
	
	@Override
	protected void performedActions(EntityManager manager) {
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		TypedQuery<Movimentacao> query = manager.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", new Categoria(1)); // Named Parameter. See also: ordinal parameter.
		List<Movimentacao> result = query.getResultList();
		
		for (Movimentacao m : result) {
			System.out.println("-----------------------------");
			System.out.println("m.descricao: " + m.getDescricao());
		}
		System.out.println("-----------------------------");

	}

}
