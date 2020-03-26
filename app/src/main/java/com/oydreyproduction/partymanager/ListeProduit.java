package com.oydreyproduction.partymanager;

public class ListeProduit {

    private int idProduit;
    private int idSoiree;

    public ListeProduit(){

    }

    public ListeProduit(int idProduit, int idSoiree){
        this.idProduit = idProduit;
        this.idSoiree = idSoiree;
    }

    public int getIdProduit(){
        return idProduit;
    }

    public int getIdSoiree(){
        return idSoiree;
    }

    public void setIdProduit(int idProduit){
        this.idProduit = idProduit;
    }

    public void setIdSoiree(int idSoiree){
        this.idSoiree = idSoiree;
    }

    public String toString(){
        return "Soirée n°" + this.idSoiree + ", produit n°" + this.idProduit + ".";
    }

}
