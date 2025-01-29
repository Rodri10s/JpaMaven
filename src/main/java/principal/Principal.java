package principal;

import javax.persistence.EntityManager;

import basicas.Categoria;
import basicas.Cliente;
import basicas.Endereco;
import basicas.Produto;
import basicas.Venda;
import basicas.VendaProduto;
import dao.GetEntityManager;

public class Principal {

	public static void main(String[] args) {
		EntityManager em = GetEntityManager.getJpaConnection();

		// Cliente cli = new Cliente();

		// Categoria cat = new Categoria();
		// cat.setDescricao("Descrição 1");

		// em.getTransaction().begin();
		// em.persist(cat);
		// em.getTransaction().commit();

		// cli.setNome("Ramon");
		// cli.setEmail("ramonrodrigues838@gmail.com");
		// cli.setFone("(87) 9 9645-7790");
		// cli.setCategoria(cat);

		// Endereco end = new Endereco();
		// end.setEstado("Pernambuco");
		// end.setCidade("Petrolândia");
		// end.setCep("56460-000");
		// end.setBairro("Centro");
		// end.setRua("Vicente Guimarães");
		// end.setNumero("84");

		// cli.setEndereco(end);

		// em.getTransaction().begin();
		// em.persist(end);
		// em.persist(cli);
		// em.getTransaction().commit();

		// em.close();

		Produto produto1 = new Produto();
		produto1.setDescricao("Chave");
		produto1.setEstoque(10);
		produto1.setValor(5.0);

		Produto produto2 = new Produto();
		produto2.setDescricao("Cadeado");
		produto2.setEstoque(10);
		produto2.setValor(10.0);

		Produto produto3 = new Produto();
		produto3.setDescricao("Chaveiro");
		produto3.setEstoque(15);
		produto3.setValor(2.0);

		Venda venda1 = new Venda();
		venda1.setDescricao("concluido");

		Venda venda2 = new Venda();
		venda2.setDescricao("em andamento");

		VendaProduto vp1 = new VendaProduto(venda1, produto1,1);
		VendaProduto vp2 = new VendaProduto(venda1, produto2, 2);
		VendaProduto vp3 = new VendaProduto(venda2, produto3, 3);

		em.getTransaction().begin();
		em.persist(produto1);
		em.persist(produto2);
		em.persist(produto3);
		em.persist(venda1);
		em.persist(venda2);
		em.persist(vp1);
		em.persist(vp2);
		em.persist(vp3);
		em.getTransaction().commit();

		em.close();

	}

}
