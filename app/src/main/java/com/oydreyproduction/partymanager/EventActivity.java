package com.oydreyproduction.partymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    int idSoiree = -1;

    TextView nom;
    TextView date;
    TextView heure;
    TextView desc;
    TextView adresse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);

        Intent intent = getIntent();

        if(intent != null){
            idSoiree = intent.getIntExtra("idSoiree", 0);
        }

        nom = findViewById(R.id.textViewEvenementNom);
        date = findViewById(R.id.textViewEvenementDate);
        heure = findViewById(R.id.textViewEvenementHeure);
        desc = findViewById(R.id.textViewEvenementDescription);
        adresse = findViewById(R.id.textViewEvenementAdresse);

        SoireeDAO soireeDAO = new SoireeDAO(this);

        soireeDAO.open();

        Soiree soiree = soireeDAO.selectionnerSoireeByID(idSoiree);

        nom.setText(soiree.getNom());
        date.setText(soiree.getDate());
        heure.setText(soiree.getHeure());
        desc.setText(soiree.getDescription());
        adresse.setText(soiree.getLieu());

        soireeDAO.close();
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

    public void goMainActivity(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SecondActivite
        Intent intent = new Intent(this,MainActivity.class);

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
