/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Categoria;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.CategoriaService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "categoriaBean")
@ViewScoped
public class CategoriaBean implements Serializable{
    
     private Categoria categoria;
    
    @EJB(name = "CategoriaService")
    private CategoriaService categoriaService;
    
    public CategoriaBean() {
        iniciarCampos();
    }
    
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void salvar() {
        categoriaService.salvar(categoria);
        iniciarCampos();
        Mensagens.adicionarMessagem("Cadastro da Categoria realizado com sucesso!");

    }
    
    public void iniciarCampos() {
        this.categoria = new Categoria();
    }
}
