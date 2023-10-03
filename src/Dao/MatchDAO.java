package Dao;

import entities.WorldCup;
import entities.WorldCupMatches;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MatchDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldcup");
    EntityManager em = emf.createEntityManager();

    public List<WorldCup> findAll(){
        return em.createQuery("FROM "+ WorldCupMatches.class.getName()).getResultList();
    }

    public WorldCupMatches getById(final int id) {
        return em.find(WorldCupMatches.class, id);
    }

    public void InsertWorldCupMatch (WorldCupMatches match){
        em.getTransaction().begin();
        em.persist(match);
        em.getTransaction().commit();
    }
}
