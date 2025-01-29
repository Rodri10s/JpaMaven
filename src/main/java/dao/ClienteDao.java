package dao;

import java.util.List;

import javax.persistence.EntityManager;

import basicas.Cliente;

public class ClienteDao {

    EntityManager em = GetEntityManager.getJpaConnection();

    public void adicionarCliente(Cliente c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public Cliente buscar(int id) {
        return em.find(Cliente.class, id);
    }

    public void atualizarCliente(Cliente c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    public void removerCliente(Cliente c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public List<Cliente> listarCliente() {
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }
}
