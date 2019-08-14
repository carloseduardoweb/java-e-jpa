package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

public abstract class Transaction {
	
	public final void executeTransaction() {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		try {
			manager.getTransaction().begin();
			performedActions(manager);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	protected abstract void performedActions(EntityManager manager);

}
