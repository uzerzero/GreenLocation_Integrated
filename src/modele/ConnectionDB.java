package modele;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modele.Vehicule;

public class ConnectionDB {
	private EntityManagerFactory factory;
	private EntityManager em;
	 
	public ConnectionDB(String db) {
		factory = Persistence.createEntityManagerFactory(db);
		em = factory.createEntityManager();
	}
	 
	public void add(Object o) {
		beginTransaction();
		em.persist(o);
		commitTransaction();
	}

	public void update(Object o) {
		beginTransaction();
		em.flush();
		commitTransaction();
	}
	
	public void del(Object o) {
		beginTransaction();
		em.remove(o);
		commitTransaction();
	}
	public void add(Categorie c) {
		beginTransaction();
		em.persist(c);
		commitTransaction();
	}
	
	public void update(Categorie c) {
		beginTransaction();
		em.flush();
		commitTransaction();
	}
	 
	public void del(Categorie c) {
		beginTransaction();
		em.remove(c);
		commitTransaction();
	}
	public Object getByID(String table, String champs, String value){
		String sql = "SELECT o FROM " + table + " o WHERE o." + champs + " = " + value;	
		Query query = em.createQuery(sql);	 
		return query.getSingleResult();
	}
	 
	@SuppressWarnings("rawtypes")
	public List getAll(String table) {
		String sql = "SELECT o FROM " + table + " o ";	
		return get(sql);
	}
	 
	@SuppressWarnings("rawtypes")
		public List get(String table, String champs, String value) {
		String sql = "SELECT o FROM " + table + " o WHERE  o." + champs + " = " + value;	 
		return get(sql);
	}
	 
	@SuppressWarnings("rawtypes")
		public List get(String sql) {
		Query query = em.createQuery(sql);	 
		return query.getResultList();
	}
	
	public void beginTransaction() {
		em.getTransaction().begin();
	}
	
	public EntityTransaction getTransaction(){
		return em.getTransaction();
	}
	
	public void commitTransaction() {
		em.getTransaction().commit();
	}
	 
	public void close() {
		em.close();
	}
}