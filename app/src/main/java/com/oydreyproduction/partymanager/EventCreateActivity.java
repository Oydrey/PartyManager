package com.oydreyproduction.partymanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EventCreateActivity extends AppCompatActivity {

    EditText nomSoiree;
    EditText dateSoiree;
    EditText lieuSoiree;
    EditText heureSoiree;
    EditText descSoiree;

    EditText produit1;
    EditText produit2;
    EditText produit3;
    EditText produit4;
    EditText produit5;
    EditText produit6;
    EditText produit7;
    EditText produit8;
    EditText produit9;
    EditText produit10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventcreate_activity);

        nomSoiree = findViewById(R.id.nom);
        dateSoiree = findViewById(R.id.date);
        lieuSoiree = findViewById(R.id.lieu);
        heureSoiree = findViewById(R.id.heure);
        descSoiree = findViewById(R.id.description);

        produit1 = findViewById(R.id.produit1);
        produit2 = findViewById(R.id.produit2);
        produit3 = findViewById(R.id.produit3);
        produit4 = findViewById(R.id.produit4);
        produit5 = findViewById(R.id.produit5);
        produit6 = findViewById(R.id.produit6);
        produit7 = findViewById(R.id.produit7);
        produit8 = findViewById(R.id.produit8);
        produit9 = findViewById(R.id.produit9);
        produit10 = findViewById(R.id.produit10);
    }

    public void back(View v) {
        //pour retourner a l’activite principale il suffit seulement d’appler la methode finish() qui vas tuer cette activite
        finish() ;
    }

    public void goMainActivity(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SecondActivite
        Intent intent = new Intent(this,MainActivity.class);

        //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici SecondActivite
        startActivity(intent);
    }

    public void saveEventAndGoMainActivity(View v) {
        // sauvegarder event dans BD
        String strNomSOiree = nomSoiree.getText().toString();
        String strLieuSoiree = lieuSoiree.getText().toString();
        String strDateSoiree = dateSoiree.getText().toString();
        String strHeureSoiree = heureSoiree.getText().toString();
        String strDescSoiree = descSoiree.getText().toString();

        String strProduit1 = produit1.getText().toString();
        String strProduit2 = produit2.getText().toString();
        String strProduit3 = produit3.getText().toString();
        String strProduit4 = produit4.getText().toString();
        String strProduit5 = produit5.getText().toString();
        String strProduit6 = produit6.getText().toString();
        String strProduit7 = produit7.getText().toString();
        String strProduit8 = produit8.getText().toString();
        String strProduit9 = produit9.getText().toString();
        String strProduit10 = produit10.getText().toString();

        SoireeDAO soireeDAO = new SoireeDAO(this);
        ProduitDAO produitDAO = new ProduitDAO(this);
        ListeProduitDAO listeProduitDAO = new ListeProduitDAO(this);

        soireeDAO.open();
        produitDAO.open();
        listeProduitDAO.open();

        Soiree soiree = new Soiree(strNomSOiree, strLieuSoiree, strDateSoiree, strHeureSoiree, strDescSoiree);

        soireeDAO.ajouter(soiree);

        String[] strProduits = {strProduit1, strProduit2, strProduit3, strProduit4, strProduit5, strProduit6, strProduit7, strProduit8, strProduit9, strProduit10};

        for(String produit : strProduits){
            if(!(produit.equals(""))){
                Log.v("Je suis la", "Dans EventCreateActivity, dans for, dans if (ajout produit)");
                Produit pProduit = new Produit(produit, 1);
                produitDAO.ajouter(pProduit);
                listeProduitDAO.ajouter(produitDAO.getIdByProduit(pProduit), soireeDAO.getIdBySoiree(soiree));
            }
        }

        soireeDAO.close();
        produitDAO.close();
        listeProduitDAO.close();


        // redirection main
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
