/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.PalestraDAO;
import dao.UsuarioDAO;
import entidades.Palestras;
import entidades.Usuario;
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
@Stateless(name = "PalestrasService")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PalestrasService {
    
    @EJB
    private PalestraDAO palestrasDAO;
    
    public void salvar(Palestras palestra) {
        this.palestrasDAO.salvar(palestra);
    }
}
