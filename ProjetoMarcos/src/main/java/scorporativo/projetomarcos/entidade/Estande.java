package scorporativo.projetomarcos.entidade;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Colocar anotacoes EJB
 * Colocar relacao com expositor
 */

@Entity
@Access(AccessType.FIELD)
public class Estande implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Estande; 
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    private Expositor expositorEstande;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEstandeExpositor(Expositor expositor){
        this.expositorEstande = expositor;
        this.expositorEstande.setNomeExpositor(expositor);
    }
}