package br.com.caelum.financas.test;

import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.model.TipoMovimentacao;
import br.com.caelum.financas.util.Transaction;

public class TestaCriaMovimentacao extends Transaction {

	public static void main(String[] args) {
		new TestaCriaMovimentacao().executeTransaction();
	}

	@Override
	public void performedActions(EntityManager manager) {
		manager.persist(new Movimentacao("123.45", TipoMovimentacao.SAIDA, "Teste", 7, Arrays.asList(1, 2)));
	}

}
