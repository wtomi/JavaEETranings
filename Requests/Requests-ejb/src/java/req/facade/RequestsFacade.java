/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import req.entities.Requests;

/**
 *
 * @author Tomi
 */
@Stateless
public class RequestsFacade extends AbstractFacade<Requests> implements RequestsFacadeLocal {

    @PersistenceContext(unitName = "Requests-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequestsFacade() {
        super(Requests.class);
    }
    
}
