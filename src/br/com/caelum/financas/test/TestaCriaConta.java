package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.Transaction;

public class TestaCriaConta extends Transaction {

	public static void main(String[] args) {
		new TestaCriaConta().executeTransaction();
	}

	@Override
	public void performedActions(EntityManager manager) {
		manager.persist(new Conta("123", "Tabajara", "456"));
		manager.persist(new Conta("246", "Tabajara", "802"));
	}

}
