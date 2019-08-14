package br.com.caelum.financas.test;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAtualizaConta {

	public static void main(String[] args) {

		Conta conta = null;

		EntityManager manager1 = new JPAUtil().getEntityManager();

		try {
			manager1.getTransaction().begin();
			conta = manager1.find(Conta.class, 2); // Note: the "find" method will get a managed entity.
			conta.setAgencia("11111-1");
			manager1.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager1.getTransaction().rollback();
		} finally {
			manager1.close(); // Note: after that, "conta" will be a detached entity.
		}

		EntityManager manager2 = new JPAUtil().getEntityManager();

		try {
			manager2.getTransaction().begin();
			conta.setAgencia("22222-2");
//			manager.persist(conta); // Error: shouldn't call persist method on a detached entity.
			manager2.merge(conta);
			manager2.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager2.getTransaction().rollback();
		} finally {
			manager2.close();
		}

	}

}
