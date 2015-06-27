package scorporativo.projetomarcos.entidade;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.Email;

/**
 * Colocar anotacoes EJB
 * COlocar anotacoes BeanValidation
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    
    @Column(name = "nome", length = 150, nullable = false)
    private String nomeCliente;
    
    @Lob
    @Basic(fetch = FetchType.LAZY, optional = true)
    @Column(name = "blob_foto", nullable = true)
    private byte[] foto;
    
    /**
     * OLHAR PARA O BANCO ANTES DE COLOCAR O NOME DA TABELA ABAIXO
     * JOINCOLUMN ATENCAAO!!!
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "id_CartaoCredito", referencedColumnName = "id_Cartao")
    private CartaoCredito cartaoCredito;
    
    @Email
    private String email;
    
    @ElementCollection
    @CollectionTable(name = "telefone",
            joinColumns = @JoinColumn(name = "id_cliente"))
    @Column(name = "NUM_TELEFONE")
    private Collection<String> telefones;


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
        this.cartaoCredito.setDono(this);
    }

}
