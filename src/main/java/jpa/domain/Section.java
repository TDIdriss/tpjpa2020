package jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {


    private long id ;

    private String section;

    private List<Fiche> fiche2 ;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public Section(){
        fiche2 = new ArrayList<>();
    }

    public Section(String section){
        this.section= section;
        this.fiche2= new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @OneToMany(mappedBy = "sect", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiche2() {
        return fiche2;
    }

    public void setFiche2(List<Fiche> fiche2) {
        this.fiche2 = fiche2;
    }


}
