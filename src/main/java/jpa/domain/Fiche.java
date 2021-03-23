package jpa.domain;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fiche {

    private long id ;

    private String libelle;
    private String lieu;
    private String date;
    private String note;
    private String temps;
    private String url;


    private List<Tags> tags;


    private Section sect;


    private User owner;


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Fiche(){
        tags = new ArrayList<Tags>();
    }

    public Fiche(String libelle, String lieu, String date, String note, String temps, String url, List<Tags> tags){
        this.libelle = libelle;
        this.lieu = lieu;
        this.date = date;
        this.note = note;
        this.temps = temps;
        this.url = url;
        this.tags = tags;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToMany(mappedBy = "fiche1", cascade = CascadeType.PERSIST)
    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    @ManyToOne()
    public Section getSect() {
        return sect;
    }

    public void setSect(Section sect) {
        this.sect = sect;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
