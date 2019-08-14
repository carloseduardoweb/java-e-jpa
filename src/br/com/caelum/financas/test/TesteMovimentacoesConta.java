package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.util.Transaction;

public class TesteMovimentacoesConta extends Transaction {

	public static void main(String[] args) {
		new TesteMovimentacoesConta().executeTransaction();
	}
	
	@Override
	protected void performedActions(EntityManager manager) {
		Movimentacao movimentacao = manager.find(Movimentacao.class, 3);
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getCliente().getNome());
		System.out.println(conta.getMovimentacoes().size());
	}

}
