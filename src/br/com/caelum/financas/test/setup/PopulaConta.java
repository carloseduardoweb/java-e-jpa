package br.com.caelum.financas.test.setup;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.EntityPopulator;

public class PopulaConta extends EntityPopulator<Conta> {

	@Override
	protected List<Conta> getEntities() {
		List<Conta> contas = new LinkedList<>();

		contas.add(new Conta("6543", "001 - BANCO DO BRASIL", "16987-8"));
		contas.add(new Conta("1745", "237 - BANCO BRADESCO", "86759-1"));
		contas.add(new Conta("4606", "341 - BANCO ITAU UNIBANCO", "46346-3"));
		contas.add(new Conta("9876", "033 - BANCO SANTANDER", "12345-6"));
		contas.add(new Conta("1234", "104 - CAIXA ECONOMICA FEDERAL", "98654-3"));

		return contas;
	}

}
