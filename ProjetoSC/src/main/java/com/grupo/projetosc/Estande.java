/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo.projetosc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "estande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estande.findAll", query = "SELECT e FROM Estande e"),
    @NamedQuery(name = "Estande.findByIdEstande", query = "SELECT e FROM Estande e WHERE e.idEstande = :idEstande")})
public class Estande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEstande")
    private Integer idEstande;
    @JoinColumn(name = "estandeArea", referencedColumnName = "nome")
    @ManyToOne(optional = false)
    private Categoria estandeArea;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "estande")
    private Expositor expositor;

    public Estande() {
    }

    public Estande(Integer idEstande) {
        this.idEstande = idEstande;
    }

    public Integer getIdEstande() {
        return idEstande;
    }

    public void setIdEstande(Integer idEstande) {
        this.idEstande = idEstande;
    }

    public Categoria getEstandeArea() {
        return estandeArea;
    }

    public void setEstandeArea(Categoria estandeArea) {
        this.estandeArea = estandeArea;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstande != null ? idEstande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estande)) {
            return false;
        }
        Estande other = (Estande) object;
        if ((this.idEstande == null && other.idEstande != null) || (this.idEstande != null && !this.idEstande.equals(other.idEstande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo.projetosc.Estande[ idEstande=" + idEstande + " ]";
    }
    
}
