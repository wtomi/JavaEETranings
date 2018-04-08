/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsjp;

import encje.Bug;
import encje.Bug_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

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

        System.out.println("Strong ************");

        findBugsCriteriaStrong("%wifi%").stream()
                .forEach(b -> System.out.println("Number: " + b.getNum()
                + " Description: " + b.getDescription()));

        System.out.println("Weak ************");

        findBugsCriteriaWeak("%wifi%").stream()
                .forEach(b -> System.out.println("Number: " + b.getNum()
                + " Description: " + b.getDescription()));

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

    public static List<Bug> findBugsCriteriaStrong(String keyword) {
        EntityManager em = EMF.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bug> cq = cb.createQuery(Bug.class);
        Root<Bug> bug = cq.from(Bug.class);
        cq.select(bug).where(cb.like(bug.get(Bug_.description), keyword));
        TypedQuery<Bug> q = em.createQuery(cq);
        return q.getResultList();
    }

    public static List<Bug> findBugsCriteriaWeak(String keyword) {
        EntityManager em = EMF.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bug> cq = cb.createQuery(Bug.class);
        Root<Bug> bug = cq.from(Bug.class);
        ParameterExpression<String> pe = cb.parameter(String.class);
        cq.select(bug).where(cb.like(bug.get("description"), pe));
        TypedQuery<Bug> q = em.createQuery(cq);
        q.setParameter(pe, keyword);
        return q.getResultList();
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
