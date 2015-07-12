/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ExpositorDAO;
import dao.PalcoDAO;
import entidades.Expositor;
import entidades.Palco;
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
@Stateless(name = "ExpositorService")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ExpositorService {
    
    @EJB
    private ExpositorDAO expositorDAO;
    
    public void salvar(Expositor expositor) {
        this.expositorDAO.salvar(expositor);
    }
}
