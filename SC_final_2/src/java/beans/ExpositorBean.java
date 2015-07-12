/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Categoria;
import entidades.Estande;
import entidades.Expositor;
import entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.CategoriaService;
import services.EstandeService;
import services.ExpositorService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "expositorBean")
@ViewScoped
public class ExpositorBean implements Serializable{
   
    private Expositor expositor;
    
    @EJB(name = "ExpositorService")
    private ExpositorService expositorService;
    
    @EJB(name = "EstandeService")
    private EstandeService estandeService;
    
    List<Estande> estandes;
    
    public ExpositorBean() {
        iniciarCampos();
    }
    
    public Expositor getExpositor() {
        return this.expositor;
    }
    
    public void salvar() {
        expositorService.salvar(expositor);
        iniciarCampos();
        Mensagens.adicionarMessagem("Cadastro do Expositor realizado com sucesso!");

    }
    
    public void iniciarCampos() {
        this.expositor = new Expositor();
    }
    
    public List<Estande> getEstandes() {
        if (this.estandes == null) {
            this.estandes = estandeService.getEstandes();
        }

        return this.estandes;
    }
    
}
