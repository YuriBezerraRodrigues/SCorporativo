/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CategoriaDAO;
import dao.EstandeDAO;
import entidades.Categoria;
import entidades.Estande;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author katllynneramannda
 */
@Stateless(name = "CategoriaService")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CategoriaService {
    
    @EJB
    private CategoriaDAO categoriaDAO;
    
    public void salvar(Categoria categoria) {
        this.categoriaDAO.salvar(categoria);
    }
    
     @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Categoria> getCategorias() {
        return (List<Categoria>) categoriaDAO.getCategorias("Categorias");
    }
}
