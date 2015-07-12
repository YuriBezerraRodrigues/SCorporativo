/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.EstandeDAO;
import dao.PalcoDAO;
import entidades.Categoria;
import entidades.Estande;
import entidades.Palco;
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
@Stateless(name = "EstandeService")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EstandeService {
    
     @EJB
    private EstandeDAO estandeDAO;
    
    public void salvar(Estande estande) {
        this.estandeDAO.salvar(estande);
    }
    
     @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Estande> getEstandes() {
        return (List<Estande>) estandeDAO.getEstandes("Estandes");
    }
}
