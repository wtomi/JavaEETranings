/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsjp;

import encje.Bug;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tomi
 */
public class BugsJP {
    
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("BugsJPPU");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void addBug(String number, String description) {
        Bug bug = new Bug(0L, number, description);
        persist(bug);
    }

    public static void persist(Object object) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
