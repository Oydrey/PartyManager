package com.oydreyproduction.partymanager;

public class Soiree {

    private int id;
    private String nom;
    private String lieu;
    private String date;
    private String heure;
    private String description;

    public Soiree(){

    }

    public Soiree(String nom, String lieu, String date, String heure, String description){
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.heure = heure;
        this.description = description;
    }

    public String getNom(){
        return nom;
    }

    public String getLieu(){
        return lieu;
    }

    public String getDate(){
        return date;
    }

    public String getHeure(){
        return heure;
    }

    public String getDescription(){
        return description;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setLieu(String lieu){
        this.lieu = lieu;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setHeure(String heure){
        this.heure = heure;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String toString(){
        return "Soirée \"" + this.nom + "\" au " + this.lieu + " le " + this.date + " a " + this.heure + ". Description : " + this.description + ".";
    }

}
