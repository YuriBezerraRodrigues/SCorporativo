/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Categoria;
import entidades.Estande;
import entidades.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.CategoriaService;
import services.EstandeService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "estandeBean")
@ViewScoped
public class EstandeBean {
    
    private Estande estande;
    
    @EJB(name = "EstandeService")
    private EstandeService estandeService;
    
    @EJB(name = "CategoriaService")
    private CategoriaService categoriaService;
    
    List<Categoria> categorias;
    
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
    
    public List<Categoria> getCategorias() {
        if (this.categorias == null) {
            this.categorias = categoriaService.getCategorias();
        }

        return this.categorias;
    }
}
