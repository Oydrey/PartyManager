package com.oydreyproduction.partymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SellierActivity extends AppCompatActivity {

    int idSoiree = -1;

    TextView nomProduit1;
    TextView qteProduit1;

    TextView nomProduit2;
    TextView qteProduit2;

    TextView nomProduit3;
    TextView qteProduit3;

    TextView nomProduit4;
    TextView qteProduit4;

    TextView nomProduit5;
    TextView qteProduit5;

    TextView nomProduit6;
    TextView qteProduit6;

    TextView nomProduit7;
    TextView qteProduit7;

    TextView nomProduit8;
    TextView qteProduit8;

    TextView nomProduit9;
    TextView qteProduit9;

    TextView nomProduit10;
    TextView qteProduit10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellier_activity);

        Intent intent = getIntent();

        if(intent != null){
            idSoiree = intent.getIntExtra("idSoiree", 0);
        }

        nomProduit1 = findViewById(R.id.sellierNomProduit1);
        qteProduit1 = findViewById(R.id.sellierQtteProduit1);

        nomProduit2 = findViewById(R.id.sellierNomProduit2);
        qteProduit2 = findViewById(R.id.sellierQtteProduit2);

        nomProduit3 = findViewById(R.id.sellierNomProduit3);
        qteProduit3 = findViewById(R.id.sellierQtteProduit3);

        nomProduit4 = findViewById(R.id.sellierNomProduit4);
        qteProduit4 = findViewById(R.id.sellierQtteProduit4);

        nomProduit5 = findViewById(R.id.sellierNomProduit5);
        qteProduit5 = findViewById(R.id.sellierQtteProduit5);

        nomProduit6 = findViewById(R.id.sellierNomProduit6);
        qteProduit6 = findViewById(R.id.sellierQtteProduit6);

        nomProduit7 = findViewById(R.id.sellierNomProduit7);
        qteProduit7 = findViewById(R.id.sellierQtteProduit7);

        nomProduit8 = findViewById(R.id.sellierNomProduit8);
        qteProduit8 = findViewById(R.id.sellierQtteProduit8);

        nomProduit9 = findViewById(R.id.sellierNomProduit9);
        qteProduit9 = findViewById(R.id.sellierQtteProduit9);

        nomProduit10 = findViewById(R.id.sellierNomProduit10);
        qteProduit10 = findViewById(R.id.sellierQtteProduit10);

        ProduitDAO produitDAO = new ProduitDAO(this);
        ListeProduitDAO listeProduitDAO = new ListeProduitDAO(this);

        produitDAO.open();
        listeProduitDAO.open();

        ListeProduit[] listeProduits = listeProduitDAO.selectionnerListeProduitByIDSoiree(idSoiree);

        TextView[] nomProduits = {nomProduit1, nomProduit2, nomProduit3, nomProduit4, nomProduit5, nomProduit6, nomProduit7, nomProduit8, nomProduit9, nomProduit10};
        TextView[] qteProduits = {qteProduit1, qteProduit2, qteProduit3, qteProduit4, qteProduit5, qteProduit6, qteProduit7, qteProduit8, qteProduit9, qteProduit10};

        int i=0;

        for(ListeProduit listeProduit : listeProduits){
            Produit produit = produitDAO.selectionnerProduitByID(listeProduitDAO.getIDProduitWithPos(idSoiree, i));
            nomProduits[i].setText(produit.getNom());
            qteProduits[i].setText(String.valueOf(produit.getQteAchetee()));
            i+=1;
        }

        produitDAO.close();
        listeProduitDAO.close();
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

    public void goEventActivity(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SecondActivite
        Intent intent=new Intent(this,EventActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici SecondActivite
        startActivity(intent);
    }

    public void goChecklistActivity(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SecondActivite
        Intent intent=new Intent(this,ChecklistActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici SecondActivite
        startActivity(intent);
    }
}
