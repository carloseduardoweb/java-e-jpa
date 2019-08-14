package br.com.caelum.financas.test.setup;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.financas.model.Cliente;
import br.com.caelum.financas.util.EntityPopulator;

public class PopulaCliente extends EntityPopulator<Cliente> {

	@Override
	protected List<Cliente> getEntities() {
		List<Cliente> clientes = new LinkedList<>();

		clientes.add(new Cliente("Maria dos Santos", "Analista de RH", "Rua das Palmeiras, 131", 1));
		clientes.add(new Cliente("Paulo Roberto de Souza", "Desenvolvedor de Software", "Avenida das Acácias, 220", 2));
		clientes.add(new Cliente("Antonio Duraes", "Web Designer", "Alameda Mamoré, 35", 3));
		clientes.add(new Cliente("Leandra Marques", "Analista de B.I.", "Rua Principal, 566", 4));
		clientes.add(new Cliente("Alexandre Duarte", "Administrador", "Avenida Paulista, 25", 5));

		return clientes;
	}

}
