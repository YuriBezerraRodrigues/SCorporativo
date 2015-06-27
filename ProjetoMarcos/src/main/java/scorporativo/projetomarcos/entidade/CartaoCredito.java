package scorporativo.projetomarcos.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Colocar anotacoes EJB
 * COlocar anotacoes BeanValidation
 */

@Entity
public class CartaoCredito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Cartao;
    
    @OneToOne(mappedBy = "cartaoCredito", optional = false)
    private Cliente dono;
    
    @Column(name = "bandeira", nullable = false, length = 100)
    private String bandeira;
    
    @Column(name = "numero", nullable = false, length = 30)
    private String numero;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataExpiracao", nullable = false)
    private Date dataExpiracao;

    public Long getId_Cartao() {
        return id_Cartao;
    }

    public void setId_Cartao(Long id_Cartao) {
        this.id_Cartao = id_Cartao;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Cartao != null ? id_Cartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }

        CartaoCredito other = (CartaoCredito) object;

        if ((this.id_Cartao == null && other.id_Cartao != null) || (this.id_Cartao != null && !this.id_Cartao.equals(other.id_Cartao))) {
            return false;
        }

        return true;
    }
}
