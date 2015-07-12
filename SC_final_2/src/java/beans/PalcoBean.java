/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Categoria;
import entidades.Palco;
import entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.CategoriaService;
import services.PalcoService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "palcoBean")
@ViewScoped
public class PalcoBean implements Serializable{
    
    private Palco palco;
    
    @EJB(name = "PalcoService")
    private PalcoService palcoService;
    
    @EJB(name = "CategoriaService")
    private CategoriaService categoriaService;
    
    List<Categoria> categorias;
    
    public PalcoBean() {
        iniciarCampos();
    }
    
    public Palco getPalco() {
        return this.palco;
    }
    
    public void salvar() {
        palcoService.salvar(palco);
        iniciarCampos();
        Mensagens.adicionarMessagem("Cadastro do Palco realizado com sucesso!");

    }
    
    public void iniciarCampos() {
        this.palco = new Palco();
    }
    
    public List<Categoria> getCategorias() {
        if (this.categorias == null) {
            this.categorias = categoriaService.getCategorias();
        }

        return this.categorias;
    }
}
