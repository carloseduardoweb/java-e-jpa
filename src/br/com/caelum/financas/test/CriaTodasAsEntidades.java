package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.Transaction;

public class CriaTodasAsEntidades extends Transaction {

	public static void main(String[] args) {
		new CriaTodasAsEntidades().executeTransaction();
	}

	@Override
	protected void performedActions(EntityManager manager) {
		// Do (almost) nothing.
	}

}
