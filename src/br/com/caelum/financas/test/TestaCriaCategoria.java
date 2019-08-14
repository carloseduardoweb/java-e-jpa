package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Categoria;
import br.com.caelum.financas.util.Transaction;

public class TestaCriaCategoria extends Transaction {

	public static void main(String[] args) {
		new TestaCriaCategoria().executeTransaction();
	}

	@Override
	public void performedActions(EntityManager manager) {
		manager.persist(new Categoria("Investimentos"));
	}

}
