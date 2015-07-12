/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ApresentadorDAO;
import dao.CategoriaDAO;
import entidades.Apresentador;
import entidades.Categoria;
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
@Stateless(name = "ApresentadorService")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ApresentadorService {
    
    @EJB
    private ApresentadorDAO apresentadorDAO;
    
    public void salvar(Apresentador apresentador) {
        this.apresentadorDAO.salvar(apresentador);
    }
}
