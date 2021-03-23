package jpa.dao;

import jpa.domain.Tags;
import jpa.domain.User;

import javax.persistence.EntityManager;
import javax.swing.text.html.HTML;
import java.util.List;

public class TagDao {

    private EntityManager manager;

    public TagDao(EntityManager manager) {
        this.manager = manager;
    }

    public void createTag(Tags tag ){
        manager.persist(tag);
    }

    public void listTags(){
        List<Tags> resultList = manager.createQuery("Select a From Tags a", Tags.class).getResultList();
        System.out.println("num of Tags:" + resultList.size());
        for (Tags next : resultList) {
            System.out.println("next Tags: " + next);
        }
    }

    public Tags chooseTag(Long id){

        return manager.createQuery("Select a From Tags a Where a.id = :id ", Tags.class).setParameter("id",id).getSingleResult();
    }
}
