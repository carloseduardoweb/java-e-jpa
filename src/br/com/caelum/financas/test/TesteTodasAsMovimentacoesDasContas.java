package br.com.caelum.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.Transaction;

public class TesteTodasAsMovimentacoesDasContas extends Transaction {

	public static void main(String[] args) {
		new TesteTodasAsMovimentacoesDasContas().executeTransaction();
	}

	@Override
	protected void performedActions(EntityManager manager) {
//		Query query = manager.createQuery("select c, m from Conta c left join c.movimentacoes m");
		TypedQuery<Conta> query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes", Conta.class);
		
//		List<Object[]> result = query.getResultList();
		List<Conta> result = query.getResultList();
		
//		for (Object[] obj : result) {
//			System.out.println("-------------------");
//			System.out.println("Conta: " + ((Conta) obj[0]).getId());
//			System.out.println("Cliente: " + ((Conta) obj[0]).getCliente().getNome());
//			System.out.println("Movimentação: " + (Movimentacao) obj[1]);
//		}
		
		for (Conta conta : result) {
			System.out.println("-------------------");
			System.out.println("Conta: " + conta.getId());
			System.out.println("Cliente: " + conta.getCliente().getNome());
			System.out.println("Movimentações: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		System.out.println("-------------------");
	}

}
