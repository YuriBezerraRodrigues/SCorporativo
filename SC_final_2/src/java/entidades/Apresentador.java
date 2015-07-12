/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author katllynneramannda
 */
@Entity
@Table(name = "apresentador")
@XmlRootElement
@SequenceGenerator(name = "SequenceApresentador",
        sequenceName = "sq_apresentador", initialValue = 1, allocationSize = 20)
@NamedQueries ( {
 @NamedQuery(name = "Apresentadores", query = "SELECT a FROM Apresentador a ORDER BY a.nome")
} )
public class Apresentador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceApresentador")
    @Basic(optional = false)
    @Column(name = "idapresentador")
    private Integer idapresentador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "especialidade")
    private String especialidade;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpalestrasApresentador")
    private Collection<Palestras> palestrasCollection;

    public Apresentador() {
    }

    public Apresentador(Integer idapresentador) {
        this.idapresentador = idapresentador;
    }

    public Apresentador(Integer idapresentador, String nome, String especialidade, String email) {
        this.idapresentador = idapresentador;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
    }

    public Integer getIdapresentador() {
        return idapresentador;
    }

    public void setIdapresentador(Integer idapresentador) {
        this.idapresentador = idapresentador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Palestras> getPalestrasCollection() {
        return palestrasCollection;
    }

    public void setPalestrasCollection(Collection<Palestras> palestrasCollection) {
        this.palestrasCollection = palestrasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idapresentador != null ? idapresentador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apresentador)) {
            return false;
        }
        Apresentador other = (Apresentador) object;
        if ((this.idapresentador == null && other.idapresentador != null) || (this.idapresentador != null && !this.idapresentador.equals(other.idapresentador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Apresentador[ idapresentador=" + idapresentador + " ]";
    }
    
}
