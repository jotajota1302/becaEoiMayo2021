package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.es.eoi.entities.Pelicula;

public class PeliculaRepositoryJPAImpl {

	public EntityManager em;

	public PeliculaRepositoryJPAImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		em = factory.createEntityManager();
	}

	public Pelicula savePelicula(Pelicula pelicula) {

		try {
			em.getTransaction().begin();
			em.persist(pelicula);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return pelicula;
	}

	public Pelicula updatePelicula(Pelicula pelicula) {

		try {
			em.getTransaction().begin();
			em.merge(pelicula);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return pelicula;
	}

	public void removePelicula(Pelicula pelicula) {

		try {
			em.getTransaction().begin();
			em.remove(pelicula);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Pelicula findPelicula(int id) {

		return em.find(Pelicula.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Pelicula> findPeliculaByGenero(String genero) {

		String hql = "from pelicula where genero = :param";
		Query query = em.createQuery(hql);
		query.setParameter("param", genero);

		return query.getResultList();	

	}

}
