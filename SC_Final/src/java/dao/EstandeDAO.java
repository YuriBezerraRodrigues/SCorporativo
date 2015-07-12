/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Estande;
import entidades.Usuario;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author katllynneramannda
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EstandeDAO {
    
    @PersistenceContext(name = "SC_FinalPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
    public void salvar(Estande estande) {
        entityManager.persist(estande);        
    }
    
    public List getEstandes(String nomeQuery) {
        Query query = entityManager.createNamedQuery(nomeQuery);
        return query.getResultList();
    }
}
