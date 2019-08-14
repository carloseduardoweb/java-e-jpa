package br.com.caelum.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.util.Transaction;

public class TesteJPQL extends Transaction {

	public static void main(String[] args) {
		new TesteJPQL().executeTransaction();
	}

	@Override 
	public void performedActions(EntityManager manager) {
//		String jpql = "select m from Movimentacao m where m.conta = ?1";
//		String jpql = "select m from Movimentacao m where m.conta = :pConta";
		String jpql = "select m from Movimentacao m order by m.valor desc";
		TypedQuery<Movimentacao> query = manager.createQuery(jpql, Movimentacao.class);
//		query.setParameter(1, new Conta(7)); // Ordinal Parameter
//		query.setParameter("pConta", new Conta(7)); // Named Parameter
		List<Movimentacao> result = query.getResultList();
		
		for (Movimentacao m : result) {
			System.out.println("-----------------------------");
			System.out.println("m.id: " + m.getId());
			System.out.println("m.descricao: " + m.getDescricao());
			System.out.println("m.tipo: " + m.getTipo());
			System.out.println("m.valor: " + m.getValor());
			System.out.println("m.conta.id: " + m.getConta().getId());
		}
		
	}

}
