package basicas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	private String email;
	private String fone;

	@ManyToOne
	@JoinColumn(name = "cartegoria_id", nullable = false)
	private Categoria categoria;

}
