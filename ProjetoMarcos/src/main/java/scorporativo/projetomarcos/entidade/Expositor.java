package scorporativo.projetomarcos.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expositor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Expositor;
    
    private Expositor nomeExpositor;

    public Expositor getNomeExpositor() {
        return nomeExpositor;
    }

    public void setNomeExpositor(Expositor nomeExpositor) {
        this.nomeExpositor = nomeExpositor;
    }


}
