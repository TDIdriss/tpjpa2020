package jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    private long id ;

    private String nom;
    private String prenom;

    private List<Fiche> fiche3 ;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public User(){
        fiche3= new ArrayList<>();
    }

    public User(String nom, String prenom ){
        this.nom=nom;
        this.prenom = prenom;
        this.fiche3 = new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @OneToMany(mappedBy = "owner" , cascade = CascadeType.PERSIST)
    public List<Fiche> getFiche3() {
        return fiche3;
    }

    public void setFiche3(List<Fiche> fiche) {
        this.fiche3 = fiche;
    }


}
