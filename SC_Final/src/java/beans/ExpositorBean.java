/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Expositor;
import entidades.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.ExpositorService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "expositorBean")
@ViewScoped
public class ExpositorBean {
   
    private Expositor expositor;
    
    @EJB(name = "ExpositorService")
    private ExpositorService expositorService;
    
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
    
}
