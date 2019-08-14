package br.com.caelum.financas.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.TipoMovimentacao;
import br.com.caelum.financas.util.Transaction;

public class TesteFuncoesJPQL extends Transaction {

	public static void main(String[] args) {
		new TesteFuncoesJPQL().executeTransaction();
	}

	@Override
	public void performedActions(EntityManager manager) {	
		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
		List<Double> medias = dao .getMediasPorDiaETipo(new Conta(1), TipoMovimentacao.SAIDA);

		for (Double media : medias) {
			System.out.println("A média é: " + media);
		}

	}

}
