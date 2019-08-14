package br.com.caelum.financas.test;

import br.com.caelum.financas.test.setup.PopulaCategoria;
import br.com.caelum.financas.test.setup.PopulaCliente;
import br.com.caelum.financas.test.setup.PopulaConta;
import br.com.caelum.financas.test.setup.PopulaMovimentacao;

public class PopulaTodasAsEntidades {

	public static void main(String[] args) {
		new PopulaCategoria().executeTransaction();
		new PopulaConta().executeTransaction();
		new PopulaCliente().executeTransaction();
		new PopulaMovimentacao().executeTransaction();
	}

}
