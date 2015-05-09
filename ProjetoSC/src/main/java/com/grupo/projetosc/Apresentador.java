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
@Table(name = "apresentador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apresentador.findAll", query = "SELECT a FROM Apresentador a"),
    @NamedQuery(name = "Apresentador.findByIdAprensentadorUsuario", query = "SELECT a FROM Apresentador a WHERE a.idAprensentadorUsuario = :idAprensentadorUsuario")})
public class Apresentador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAprensentador_Usuario")
    private Integer idAprensentadorUsuario;
    @JoinColumn(name = "idAprensentador_Usuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Apresentador() {
    }

    public Apresentador(Integer idAprensentadorUsuario) {
        this.idAprensentadorUsuario = idAprensentadorUsuario;
    }

    public Integer getIdAprensentadorUsuario() {
        return idAprensentadorUsuario;
    }

    public void setIdAprensentadorUsuario(Integer idAprensentadorUsuario) {
        this.idAprensentadorUsuario = idAprensentadorUsuario;
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
        hash += (idAprensentadorUsuario != null ? idAprensentadorUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apresentador)) {
            return false;
        }
        Apresentador other = (Apresentador) object;
        if ((this.idAprensentadorUsuario == null && other.idAprensentadorUsuario != null) || (this.idAprensentadorUsuario != null && !this.idAprensentadorUsuario.equals(other.idAprensentadorUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo.projetosc.Apresentador[ idAprensentadorUsuario=" + idAprensentadorUsuario + " ]";
    }
    
}
