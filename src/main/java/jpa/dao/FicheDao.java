package jpa.dao;


import jpa.domain.Fiche;

import javax.persistence.EntityManager;

public class FicheDao {

    private EntityManager manager;

public FicheDao(EntityManager manager){
    this.manager = manager;
}
    public void createFiche(Fiche fiche){

    manager.persist(fiche);


    }
}
