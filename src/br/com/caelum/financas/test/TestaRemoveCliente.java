package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Cliente;
import br.com.caelum.financas.util.Transaction;

public class TestaRemoveCliente extends Transaction {

	public static void main(String[] args) {
		new TestaRemoveCliente().executeTransaction();
	}

	@Override
	public void performedActions(EntityManager manager) {
		Cliente cliente = manager.find(Cliente.class, 6);
		manager.remove(cliente);		
	}
	
}
