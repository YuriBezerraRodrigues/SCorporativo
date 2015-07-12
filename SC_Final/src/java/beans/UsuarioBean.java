/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean {
    
    private Usuario usuario;
    
    @EJB(name = "UsuarioService")
    private UsuarioService usuarioService;
    
    public UsuarioBean() {
        iniciarCampos();
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void salvar() {
        usuarioService.salvar(usuario);
        iniciarCampos();
        Mensagens.adicionarMessagem("Cadastro do Usuario realizado com sucesso!");

    }
    
    public void iniciarCampos() {
        this.usuario = new Usuario();
    }
    
    
}
