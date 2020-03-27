package com.oydreyproduction.partymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChecklistActivity extends AppCompatActivity {

    int idSoiree;

    TextView nomProduit1;
    EditText qteAcheteeProduit1;
    EditText qteNecessaireProduit1;

    TextView nomProduit2;
    EditText qteAcheteeProduit2;
    EditText qteNecessaireProduit2;

    TextView nomProduit3;
    EditText qteAcheteeProduit3;
    EditText qteNecessaireProduit3;

    TextView nomProduit4;
    EditText qteAcheteeProduit4;
    EditText qteNecessaireProduit4;

    TextView nomProduit5;
    EditText qteAcheteeProduit5;
    EditText qteNecessaireProduit5;

    TextView nomProduit6;
    EditText qteAcheteeProduit6;
    EditText qteNecessaireProduit6;

    TextView nomProduit7;
    EditText qteAcheteeProduit7;
    EditText qteNecessaireProduit7;

    TextView nomProduit8;
    EditText qteAcheteeProduit8;
    EditText qteNecessaireProduit8;

    TextView nomProduit9;
    EditText qteAcheteeProduit9;
    EditText qteNecessaireProduit9;

    TextView nomProduit10;
    EditText qteAcheteeProduit10;
    EditText qteNecessaireProduit10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist_activity);

        Intent intent = getIntent();

        if(intent != null){
            idSoiree = intent.getIntExtra("idSoiree", 0);
        }

        nomProduit1 = findViewById(R.id.nomProduit1);
        qteAcheteeProduit1 = findViewById(R.id.qtteProduit1);
        qteNecessaireProduit1 = findViewById(R.id.qtteSouhaiteProduit1);

        nomProduit2 = findViewById(R.id.nomProduit2);
        qteAcheteeProduit2 = findViewById(R.id.qtteProduit2);
        qteNecessaireProduit2 = findViewById(R.id.qtteSouhaiteProduit2);

        nomProduit3 = findViewById(R.id.nomProduit3);
        qteAcheteeProduit3 = findViewById(R.id.qtteProduit3);
        qteNecessaireProduit3 = findViewById(R.id.qtteSouhaiteProduit3);

        nomProduit4 = findViewById(R.id.nomProduit4);
        qteAcheteeProduit4 = findViewById(R.id.qtteProduit4);
        qteNecessaireProduit4 = findViewById(R.id.qtteSouhaiteProduit4);

        nomProduit5 = findViewById(R.id.nomProduit5);
        qteAcheteeProduit5 = findViewById(R.id.qtteProduit5);
        qteNecessaireProduit5 = findViewById(R.id.qtteSouhaiteProduit5);

        nomProduit6 = findViewById(R.id.nomProduit6);
        qteAcheteeProduit6 = findViewById(R.id.qtteProduit6);
        qteNecessaireProduit6 = findViewById(R.id.qtteSouhaiteProduit6);

        nomProduit7 = findViewById(R.id.nomProduit7);
        qteAcheteeProduit7 = findViewById(R.id.qtteProduit7);
        qteNecessaireProduit7 = findViewById(R.id.qtteSouhaiteProduit7);

        nomProduit8 = findViewById(R.id.nomProduit8);
        qteAcheteeProduit8 = findViewById(R.id.qtteProduit8);
        qteNecessaireProduit8 = findViewById(R.id.qtteSouhaiteProduit8);

        nomProduit9 = findViewById(R.id.nomProduit9);
        qteAcheteeProduit9 = findViewById(R.id.qtteProduit9);
        qteNecessaireProduit9 = findViewById(R.id.qtteSouhaiteProduit9);

        nomProduit10 = findViewById(R.id.nomProduit10);
        qteAcheteeProduit10 = findViewById(R.id.qtteProduit10);
        qteNecessaireProduit10 = findViewById(R.id.qtteSouhaiteProduit10);

        ProduitDAO produitDAO = new ProduitDAO(this);
        ListeProduitDAO listeProduitDAO = new ListeProduitDAO(this);

        produitDAO.open();
        listeProduitDAO.open();

        

        produitDAO.close();
        listeProduitDAO.close();
    }


    public void back(View v) {
        //pour retourner a l’activite principale il suffit seulement d’appler la methode finish() qui vas tuer cette activite
        finish() ;
    }

    public void goSellierActivity(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SecondActivite
        Intent intent = new Intent(this,SellierActivity.class);
        intent.putExtra("idSoiree", idSoiree);
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

    public void goMainActivity(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SecondActivite
        Intent intent = new Intent(this,MainActivity.class);

        //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici SecondActivite
        startActivity(intent);
    }

    public void saveQuantityAndGoMainSellier(View v) {
        // sauvegarder quantité dans BD

        // redirection sellier
        Intent intent = new Intent(this,SellierActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        startActivity(intent);
    }

}
