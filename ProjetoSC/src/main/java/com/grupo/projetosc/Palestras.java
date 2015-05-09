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
@Table(name = "palestras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestras.findAll", query = "SELECT p FROM Palestras p"),
    @NamedQuery(name = "Palestras.findByIdPalestrasUsuario", query = "SELECT p FROM Palestras p WHERE p.idPalestrasUsuario = :idPalestrasUsuario"),
    @NamedQuery(name = "Palestras.findByTitulo", query = "SELECT p FROM Palestras p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Palestras.findByValor", query = "SELECT p FROM Palestras p WHERE p.valor = :valor")})
public class Palestras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPalestras_Usuario")
    private Integer idPalestrasUsuario;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "idPalestras_Usuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Palestras() {
    }

    public Palestras(Integer idPalestrasUsuario) {
        this.idPalestrasUsuario = idPalestrasUsuario;
    }

    public Palestras(Integer idPalestrasUsuario, String titulo, double valor) {
        this.idPalestrasUsuario = idPalestrasUsuario;
        this.titulo = titulo;
        this.valor = valor;
    }

    public Integer getIdPalestrasUsuario() {
        return idPalestrasUsuario;
    }

    public void setIdPalestrasUsuario(Integer idPalestrasUsuario) {
        this.idPalestrasUsuario = idPalestrasUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
        hash += (idPalestrasUsuario != null ? idPalestrasUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestras)) {
            return false;
        }
        Palestras other = (Palestras) object;
        if ((this.idPalestrasUsuario == null && other.idPalestrasUsuario != null) || (this.idPalestrasUsuario != null && !this.idPalestrasUsuario.equals(other.idPalestrasUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo.projetosc.Palestras[ idPalestrasUsuario=" + idPalestrasUsuario + " ]";
    }
    
}
