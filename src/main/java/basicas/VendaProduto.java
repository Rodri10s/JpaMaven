package basicas;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_venda_produto")
@Data
public class VendaProduto implements Serializable {

    @EmbeddedId
    private VendaProdutoPK id = new VendaProdutoPK();

    private int quantidade;

    public VendaProduto(Venda venda, Produto produto, int quantidade) {
        id.setProduto(produto);
        id.setVenda(venda);
        this.quantidade = quantidade;
    }

}
