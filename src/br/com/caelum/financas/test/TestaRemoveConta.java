package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.Transaction;

public class TestaRemoveConta extends Transaction {

	public static void main(String[] args) {
		new TestaRemoveConta().executeTransaction();
	}

	@Override
	public void performedActions(EntityManager manager) {
		Conta conta = manager.find(Conta.class, 1);
		manager.remove(conta);		
	}
	
}
