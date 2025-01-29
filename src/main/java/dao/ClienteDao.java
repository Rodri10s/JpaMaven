package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    public List<Cliente> buscarCliente(String nome) {
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c where c.nome = :name", Cliente.class);
        query.setParameter("name", nome);

        return query.getResultList();
    }

    public List<Cliente> buscarPrimeirosCliente(int qtd) {
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);
        query.setMaxResults(qtd);

        return query.getResultList();
    }

    public List<Cliente> buscarCategoria(int id) {
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c join c.categoria where c.categora= :id",
                Cliente.class);
        query.setParameter("id", id);

        return query.getResultList();
    }
}
