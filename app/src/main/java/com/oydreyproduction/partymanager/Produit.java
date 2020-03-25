package com.oydreyproduction.partymanager;

public class Produit{

    private int id;
    private String nom;
    private int qteNecessaire;
    private int qteAchetee;

    public Produit(){

    }

    public Produit(String nom, int qteNecessaire){
        this.nom = nom;
        this.qteNecessaire = qteNecessaire;
        this.qteAchetee = 0;
    }

    public int getId(){
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQteNecessaire() {
        return qteNecessaire;
    }

    public int getQteAchetee() {
        return qteAchetee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQteNecessaire(int qteNecessaire) {
        this.qteNecessaire = qteNecessaire;
    }

    public void setQteAchetee(int qteAchetee) {
        this.qteAchetee = qteAchetee;
    }

    public String toString() {
        return "Produit : " + this.nom + ", Quantite : " + this.qteAchetee + "/" + this.qteNecessaire;
    }
}
