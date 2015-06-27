/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorporativo.projetomarcos.entidade;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Usuário
 */
public class Tema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id_Tema;

    public Long getId_Tema() {
        return id_Tema;
    }

    public void setId_Tema(Long id_Tema) {
        this.id_Tema = id_Tema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Tema != null ? id_Tema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tema other = (Tema) obj;
        if (!Objects.equals(this.id_Tema, other.id_Tema)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[ id=" + id_Tema + " ]";
    }

}
