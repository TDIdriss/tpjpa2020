package jpa.dao;


import jpa.domain.Fiche;

import javax.persistence.EntityManager;
import java.util.List;

public class FicheDao {

    private EntityManager manager;

public FicheDao(EntityManager manager){
    this.manager = manager;
}
    public void createFiche(Fiche fiche){

    int numOfFiche = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        if (numOfFiche == 0) {
            manager.persist(fiche);

        }
    }


    public void listFiche(){
        List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
        System.out.println("num of fiche:" + resultList.size());
        for (Fiche next : resultList) {
            System.out.println("next fiche: " + next);
        }
    }
}
