package br.com.caelum.financas.test.setup;

import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.model.TipoMovimentacao;
import br.com.caelum.financas.util.EntityPopulator;

public class PopulaMovimentacao extends EntityPopulator<Movimentacao> {

	@Override
	protected List<Movimentacao> getEntities() {
		List<Movimentacao> movimentacoes = new LinkedList<>();
		
		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DAY_OF_MONTH, -1);
		
		movimentacoes.add(new Movimentacao("150.00", TipoMovimentacao.SAIDA, ontem, "Livro", 1, Arrays.asList(1, 2)));
		movimentacoes.add(new Movimentacao("500.00", TipoMovimentacao.SAIDA, ontem, "Despensa", 1, Arrays.asList(3)));
		movimentacoes.add(new Movimentacao("100.00", TipoMovimentacao.SAIDA, "Petshop", 1, Arrays.asList(3)));
		movimentacoes.add(new Movimentacao("3000.00", TipoMovimentacao.ENTRADA, "Salário", 1, Arrays.asList(4)));
		movimentacoes.add(new Movimentacao("40.00", TipoMovimentacao.SAIDA, ontem, "Cinema", 2, Arrays.asList(2)));
		movimentacoes.add(new Movimentacao("80.00", TipoMovimentacao.SAIDA, "Encadernação do TCC", 2, Arrays.asList(1)));
		
//		movimentacoes.add(new Movimentacao("1500.00", TipoMovimentacao.SAIDA, "Teste", 1)); // Teste
		
		return movimentacoes;
	}

}
