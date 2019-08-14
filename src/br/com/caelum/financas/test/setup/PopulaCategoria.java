package br.com.caelum.financas.test.setup;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.financas.model.Categoria;
import br.com.caelum.financas.util.EntityPopulator;

public class PopulaCategoria extends EntityPopulator<Categoria> {
	
	@Override
	protected List<Categoria> getEntities() {
		List<Categoria> categorias = new LinkedList<>();
		
		categorias.add(new Categoria("Faculdade"));
		categorias.add(new Categoria("Lazer"));
		categorias.add(new Categoria("Despesas"));
		categorias.add(new Categoria("Negócios"));
	
		return categorias;
	}
}
