package com.oydreyproduction.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creation d'une instance de la classe ProduitBDD
        ProduitBDD produitBDD = new ProduitBDD(this);

        //creation d'un produit
        Produit produit = new Produit("Chips", 5);

        //on ouvre la base de donnee afin d'ecrire dedans
        produitBDD.open();

        Produit myOldProduit = produitBDD.getProduitWithNom("Old Produit");

        //si aucun produit n'est retourne
        if(myOldProduit == null){
            Toast.makeText(this, "L'ancien produit n'existe pas", Toast.LENGTH_LONG).show();
        }
        //si le produit est retourne
        else{
            Toast.makeText(this, "L'ancien produit existe", Toast.LENGTH_LONG).show();
        }

        //on insere le produit cree
        produitBDD.insertProduit(produit);

        //on verifie qu'on l'a bien insere dans la BDD
        Produit produitFromBdd = produitBDD.getProduitWithNom(produit.getNom());

        //si un produit est retourne
        if(produitFromBdd != null){
            Toast.makeText(this, produitFromBdd.toString(), Toast.LENGTH_LONG).show();

            //on modifie le nom du produit
            produitFromBdd.setNom("Chips modif");

            //on met a jour la BDD
            produitBDD.updateProduit(produitFromBdd.getId(), produitFromBdd);
        }

        //on extrait le produit de la BDD grace au nouveau nom
        produitFromBdd = produitBDD.getProduitWithNom("Chips modif");

        //si il existe un produit poseedant ce nom dans la BDD
        if(produitFromBdd != null){
            Toast.makeText(this, produitFromBdd.toString(), Toast.LENGTH_LONG).show();

            //on supprime le livre de la BDD grace a son ID
            produitBDD.removeProduitWithID(produitFromBdd.getId());
        }

        //on essaie d'extraire de nouveau le produit de la BDD grace a son nouveau nom
        produitFromBdd = produitBDD.getProduitWithNom("Chips modif");

        //si aucun produit n'est retourne
        if(produitFromBdd == null){
            Toast.makeText(this, "ce produit n'existe plus dans la BDD", Toast.LENGTH_LONG).show();
        }
        //si le produit existe mais normalement non
        else{
            Toast.makeText(this, "ce produit existe dans la BDD", Toast.LENGTH_LONG).show();
        }

        //on cree un produit qu'on voudra retrouver a la prochaine execution de l'application
        Produit produit2 = new Produit("Old Produit", 2);
        produitBDD.insertProduit(produit2);

        produitBDD.close();
    }
}
