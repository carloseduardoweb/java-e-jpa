package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager manager;

	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	//Traditional way to create a query  
//	public List<Double> getMediasPorDiaETipo(Conta conta, TipoMovimentacao tipo) {
//		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo group by m.data";
//
//		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
//
//		query.setParameter("pConta", conta);
//		query.setParameter("pTipo", tipo);
//
//		return query.getResultList();
//	}
	
	public List<Double> getMediasPorDiaETipo(Conta conta, TipoMovimentacao tipo) {
		return manager.createNamedQuery("Movimentacao.MediasPorDiaETipo", Double.class)
				.setParameter("pConta", conta)
				.setParameter("pTipo", tipo)
				.getResultList();
	}

}
