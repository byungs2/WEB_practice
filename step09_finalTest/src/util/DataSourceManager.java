package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataSourceManager {
	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("step09_finalTest");
	}
	public static EntityManager getEntityManger() {
		return emf.createEntityManager();
	}
	public static void close() {
		emf.close();
	}
}
