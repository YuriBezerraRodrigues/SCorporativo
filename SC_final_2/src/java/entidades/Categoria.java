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
@Table(name = "categoria")
@XmlRootElement
@SequenceGenerator(name = "SequenceCategoria",
        sequenceName = "sq_categoria", initialValue = 1, allocationSize = 20)
@NamedQueries ( {
 @NamedQuery(name = "Categorias", query = "SELECT c FROM Categoria c ORDER BY c.nome")
} )
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceCategoria")
    @Basic(optional = false)
    @Column(name = "idcategoria")
    private Integer idcategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estandecategoria")
    private Collection<Estande> estandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpalcoCategoria")
    private Collection<Palco> palcoCollection;

    public Categoria() {
    }

    public Categoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Categoria(Integer idcategoria, String nome) {
        this.idcategoria = idcategoria;
        this.nome = nome;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Estande> getEstandeCollection() {
        return estandeCollection;
    }

    public void setEstandeCollection(Collection<Estande> estandeCollection) {
        this.estandeCollection = estandeCollection;
    }

    @XmlTransient
    public Collection<Palco> getPalcoCollection() {
        return palcoCollection;
    }

    public void setPalcoCollection(Collection<Palco> palcoCollection) {
        this.palcoCollection = palcoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoria != null ? idcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcategoria == null && other.idcategoria != null) || (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Categoria[ idcategoria=" + idcategoria + " ]";
    }
    
}
