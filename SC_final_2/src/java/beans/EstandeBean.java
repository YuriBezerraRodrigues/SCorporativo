/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Estande;
import entidades.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.EstandeService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "estandeBean")
@ViewScoped
public class EstandeBean implements Serializable{
    
    private Estande estande;
    
    @EJB(name = "EstandeService")
    private EstandeService estandeService;
    
    public EstandeBean() {
        iniciarCampos();
    }
    
    public Estande getEstande() {
        return this.estande;
    }
    
    public void salvar() {
        estandeService.salvar(estande);
        iniciarCampos();
        Mensagens.adicionarMessagem("Cadastro do Estande realizado com sucesso!");

    }
    
    public void iniciarCampos() {
        this.estande = new Estande();
    }
}
