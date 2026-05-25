package com.msedcl.main.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY 
		= Persistence.createEntityManagerFactory("employee-crud");

	public static EntityManager getEntityManager() {
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}

}
