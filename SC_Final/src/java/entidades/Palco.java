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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author katllynneramannda
 */
@Entity
@Table(name = "palco")
@XmlRootElement
@SequenceGenerator(name = "SequencePalco",
        sequenceName = "sq_palco", initialValue = 1, allocationSize = 20)
public class Palco implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequencePalco")
    @Column(name = "idpalco")
    private Integer idpalco;
    
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tema")
    private String tema;
    
    
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "idpalco_categoria", referencedColumnName = "idcategoria")
    private Categoria idpalcoCategoria;

    public Palco() {
    }

    public Palco(Integer idpalco) {
        this.idpalco = idpalco;
    }

    public Palco(Integer idpalco, String tema) {
        this.idpalco = idpalco;
        this.tema = tema;
    }

    public Integer getIdpalco() {
        return idpalco;
    }

    public void setIdpalco(Integer idpalco) {
        this.idpalco = idpalco;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Categoria getIdpalcoCategoria() {
        return idpalcoCategoria;
    }

    public void setIdpalcoCategoria(Categoria idpalcoCategoria) {
        this.idpalcoCategoria = idpalcoCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpalco != null ? idpalco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palco)) {
            return false;
        }
        Palco other = (Palco) object;
        if ((this.idpalco == null && other.idpalco != null) || (this.idpalco != null && !this.idpalco.equals(other.idpalco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Palco[ idpalco=" + idpalco + " ]";
    }
    
}
