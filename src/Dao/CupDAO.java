package Dao;

import entities.WorldCup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CupDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldcup");
    EntityManager em = emf.createEntityManager();

    public List<WorldCup> findAll(){
        return em.createQuery("FROM "+WorldCup.class.getName()).getResultList();
    }

    public WorldCup getById(final int id) {

        return em.find(WorldCup.class, id);
    }

    public void InsertWorldCup (WorldCup cup){
        em.getTransaction().begin();
        em.persist(cup);
        em.getTransaction().commit();
    }

    public List<WorldCup> Desempenho(String selecao){
        String sql = "Select  w "+
                "from WorldCup w " +
                "where winner  =  \""+selecao+
                "\" or runnersUp =  \""+selecao+
                "\" or third =  \""+selecao+
                "\" or fourth = \""+selecao+"\"";

        List<WorldCup> cups = (List<WorldCup>) em.createQuery(sql,WorldCup.class).getResultList();

        return cups;
    }
}
