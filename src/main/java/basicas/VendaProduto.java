package basicas;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_venda_produto")
public class VendaProduto implements Serializable {

    @EmbeddedId
    private VendaProdutoPK id = new VendaProdutoPK();

    private int quantidade;

    public VendaProduto() {
    }

    public VendaProduto(Venda venda, Produto produto, int quantidade) {
        id.setProduto(produto);
        id.setVenda(venda);
        this.quantidade = quantidade;
    }

    public VendaProdutoPK getId() {
        return id;
    }

    public void setId(VendaProdutoPK id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + quantidade;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VendaProduto other = (VendaProduto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (quantidade != other.quantidade)
            return false;
        return true;
    }

}
