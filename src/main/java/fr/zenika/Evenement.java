package fr.zenika;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Evenement extends PanacheEntity {
    private String nom;

    private LocalDate debut;

    private int duree;

    public Evenement() {
    }

    public Evenement(String nom, LocalDate debut, int duree) {
        this.nom = nom;
        this.debut = debut;
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
