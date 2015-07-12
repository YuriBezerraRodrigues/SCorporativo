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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "estande")
@XmlRootElement
@SequenceGenerator(name = "SequenceEstande",
        sequenceName = "sq_estande", initialValue = 1, allocationSize = 20)
@NamedQueries ( {
 @NamedQuery(name = "Estandes", query = "SELECT e FROM Estande e ORDER BY e.nome")
} )
public class Estande implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
  
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceEstande")
    @Basic(optional = false)
    @Column(name = "idestande")
    private Integer idestande;
    @JoinColumn(name = "estandecategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria estandecategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestandeExpositor")
    private Collection<Expositor> expositorCollection;

    public Estande() {
    }

    public Estande(Integer idestande) {
        this.idestande = idestande;
    }

    public Integer getIdestande() {
        return idestande;
    }

    public void setIdestande(Integer idestande) {
        this.idestande = idestande;
    }

    public Categoria getEstandecategoria() {
        return estandecategoria;
    }

    public void setEstandecategoria(Categoria estandecategoria) {
        this.estandecategoria = estandecategoria;
    }

    @XmlTransient
    public Collection<Expositor> getExpositorCollection() {
        return expositorCollection;
    }

    public void setExpositorCollection(Collection<Expositor> expositorCollection) {
        this.expositorCollection = expositorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestande != null ? idestande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estande)) {
            return false;
        }
        Estande other = (Estande) object;
        if ((this.idestande == null && other.idestande != null) || (this.idestande != null && !this.idestande.equals(other.idestande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estande[ idestande=" + idestande + " ]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
