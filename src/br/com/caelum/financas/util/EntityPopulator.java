package br.com.caelum.financas.util;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class EntityPopulator<T> extends Transaction {

	@Override
	protected final void performedActions(EntityManager manager) {
		for (T entity : getEntities()) {
			manager.persist(entity);
		}
	}

	protected abstract List<T> getEntities();
	
}
