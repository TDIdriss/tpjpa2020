package jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tags {

   private long id ;

   private String tag;


    private List<Fiche> fiche1 ;


    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public Tags(){
        fiche1 = new ArrayList<>();
    }

    public Tags(String tag){
        this.fiche1 = new ArrayList<>();
        this.tag=tag;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @ManyToMany
    public List<Fiche> getFiche1() {
        return fiche1;
    }

    public void setFiche1(List<Fiche> fiche1) {
        this.fiche1 = fiche1;
    }
}
