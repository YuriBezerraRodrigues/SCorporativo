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
public class Estande extends Entidade implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
  
    
    @JoinColumn(name = "estandecategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria estandecategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestandeExpositor")
    private Collection<Expositor> expositorCollection;

    public Estande() {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
