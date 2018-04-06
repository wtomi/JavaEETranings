/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsjp;

import encje.Bug;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Tomi
 */
public class BugsJP {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("BugsJPPU");

    public static void main(String[] args) {
        addBug("b001", "Lost wifi connection");
        addBug("b002", "Turning off wifi does not work");
        addBug("b003", "Execution slow when on battery");
        for (Bug b : findBugs("%wifi%")) {
            System.out.println("Number: " + b.getNum()
                    + " Description: " + b.getDescription());
        }
        bulkDeleteBugs();
    }

    public static void addBug(String number, String description) {
        Bug bug = new Bug(0L, number, description);
        persist(bug);
    }

    public static List<Bug> findBugs(String keyword) {
        EntityManager em = EMF.createEntityManager();
        try {
            Query query = em.createNamedQuery("Bug.findByKeyword", Bug.class);
            query.setParameter("keyword", keyword);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static void bulkDeleteBugs() {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("DELETE FROM Bug").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
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
