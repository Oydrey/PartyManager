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

    public String toString(){
        return "Soirée n°" + this.idSoiree + ", produit n°" + this.idProduit + ".";
    }

}
