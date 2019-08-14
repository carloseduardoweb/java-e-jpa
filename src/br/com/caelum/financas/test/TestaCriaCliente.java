package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Cliente;
import br.com.caelum.financas.util.Transaction;

public class TestaCriaCliente extends Transaction {

	public static void main(String[] args) {
		new TestaCriaCliente().executeTransaction();
	}

	@Override
	public void performedActions(EntityManager manager) {
//		String jpql = "select c from Conta c where c.banco = 'Tabajara'";
//		List<Conta> contas = manager.createQuery(jpql).getResultList();
//		Integer contaId = contas.get(0).getId();
		Integer contaId = 6;
		
		manager.persist(new Cliente("Carlos", "Desenvolvedor", "Rua Estreita, 123", contaId));
	}

}
