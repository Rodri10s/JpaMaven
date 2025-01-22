package dao;

import java.util.List;

import javax.persistence.EntityManager;

import basicas.Categoria;

public class CategoriaDao {
	
	private EntityManager em=GetEntityManager.getJpaConnection();
	
	
	public void adicionar(Categoria c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public Categoria buscarCategoriaId(int id) {
		return em.find(Categoria.class , id);
	}
	
	public void atualizar(Categoria c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}
	
	public List<Categoria> listar(){
		
		return em.createQuery("select c from Categoria c", Categoria.class).getResultList();
		
	}

}
