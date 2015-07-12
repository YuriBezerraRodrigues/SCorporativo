/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author katllynneramannda
 */
@Entity
@Table(name = "expositor")
@XmlRootElement
@SequenceGenerator(name = "SequenceExpositor",
        sequenceName = "sq_expositor", initialValue = 1, allocationSize = 20)
public class Expositor extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;
  
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "idestande_expositor", referencedColumnName = "idestande")
    @ManyToOne(optional = false)
    private Estande idestandeExpositor;

    public Expositor() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estande getIdestandeExpositor() {
        return idestandeExpositor;
    }

    public void setIdestandeExpositor(Estande idestandeExpositor) {
        this.idestandeExpositor = idestandeExpositor;
    }
    
}
