/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author katllynneramannda
 */
@Entity
@Table(name = "palestras")
@XmlRootElement
@SequenceGenerator(name = "SequencePalestras",
        sequenceName = "sq_palestras", initialValue = 1, allocationSize = 20)
public class Palestras extends Entidade implements Serializable {

    private static final long serialVersionUID = 1L;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    
 
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "datapalestra")
    @Temporal(TemporalType.DATE)
    private Date datapalestra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @JoinColumn(name = "idpalestras_usuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idpalestrasUsuario;
    @JoinColumn(name = "idpalestras_apresentador", referencedColumnName = "idapresentador")
    @ManyToOne(fetch = FetchType.EAGER)
    private Apresentador idpalestrasApresentador;

    public Palestras() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Date getDatapalestra() {
        return datapalestra;
    }

    public void setDatapalestra(Date datapalestra) {
        this.datapalestra = datapalestra;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Usuario getIdpalestrasUsuario() {
        return idpalestrasUsuario;
    }

    public void setIdpalestrasUsuario(Usuario idpalestrasUsuario) {
        this.idpalestrasUsuario = idpalestrasUsuario;
    }

    public Apresentador getIdpalestrasApresentador() {
        return idpalestrasApresentador;
    }

    public void setIdpalestrasApresentador(Apresentador idpalestrasApresentador) {
        this.idpalestrasApresentador = idpalestrasApresentador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
