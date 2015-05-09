/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo.projetosc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "expositor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expositor.findAll", query = "SELECT e FROM Expositor e"),
    @NamedQuery(name = "Expositor.findByIdExpositor", query = "SELECT e FROM Expositor e WHERE e.idExpositor = :idExpositor"),
    @NamedQuery(name = "Expositor.findByIdEstandeExpositor", query = "SELECT e FROM Expositor e WHERE e.idEstandeExpositor = :idEstandeExpositor")})
public class Expositor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idExpositor")
    private Integer idExpositor;
    @Basic(optional = false)
    @Column(name = "idEstande_Expositor")
    private int idEstandeExpositor;
    @JoinColumn(name = "idExpositor", referencedColumnName = "idEstande", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Estande estande;
    @JoinColumn(name = "idExpositor", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Expositor() {
    }

    public Expositor(Integer idExpositor) {
        this.idExpositor = idExpositor;
    }

    public Expositor(Integer idExpositor, int idEstandeExpositor) {
        this.idExpositor = idExpositor;
        this.idEstandeExpositor = idEstandeExpositor;
    }

    public Integer getIdExpositor() {
        return idExpositor;
    }

    public void setIdExpositor(Integer idExpositor) {
        this.idExpositor = idExpositor;
    }

    public int getIdEstandeExpositor() {
        return idEstandeExpositor;
    }

    public void setIdEstandeExpositor(int idEstandeExpositor) {
        this.idEstandeExpositor = idEstandeExpositor;
    }

    public Estande getEstande() {
        return estande;
    }

    public void setEstande(Estande estande) {
        this.estande = estande;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExpositor != null ? idExpositor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expositor)) {
            return false;
        }
        Expositor other = (Expositor) object;
        if ((this.idExpositor == null && other.idExpositor != null) || (this.idExpositor != null && !this.idExpositor.equals(other.idExpositor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo.projetosc.Expositor[ idExpositor=" + idExpositor + " ]";
    }
    
}
