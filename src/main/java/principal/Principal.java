package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basicas.Categoria;
import basicas.Cliente;
import basicas.Endereco;
import dao.GetEntityManager;

public class Principal {

	public static void main(String[] args) {
		EntityManager em = GetEntityManager.getJpaConnection();

		Cliente cli = new Cliente();

		Categoria cat = new Categoria();
		cat.setDescricao("Descrição 1");

		em.getTransaction().begin();
		em.persist(cat);
		em.getTransaction().commit();

		cli.setNome("Ramon");
		cli.setEmail("ramonrodrigues838@gmail.com");
		cli.setFone("(87) 9 9645-7790");
		cli.setCategoria(cat);

		Endereco end = new Endereco();
		end.setEstado("Pernambuco");
		end.setCidade("Petrolândia");
		end.setCep("56460-000");
		end.setBairro("Centro");
		end.setRua("Vicente Guimarães");
		end.setNumero("84");

		cli.setEndereco(end);

		em.getTransaction().begin();
		em.persist(end);
		em.persist(cli);
		em.getTransaction().commit();

		em.close();
	}

}
