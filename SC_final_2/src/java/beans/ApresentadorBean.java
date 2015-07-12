/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Apresentador;
import entidades.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.ApresentadorService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "apresentadorBean")
@ViewScoped
public class ApresentadorBean implements Serializable{
    
    private Apresentador apresentador;
    
    @EJB(name = "ApresentadorService")
    private ApresentadorService apresentadorService;
    
    public ApresentadorBean() {
        iniciarCampos();
    }
    
    public Apresentador getApresentador() {
        return this.apresentador;
    }
    
    public void salvar() {
        apresentadorService.salvar(apresentador);
        iniciarCampos();
        Mensagens.adicionarMessagem("Cadastro do Apresentador realizado com sucesso!");

    }
    
    public void iniciarCampos() {
        this.apresentador = new Apresentador();
    }
    
}
