package com.oydreyproduction.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button15;
    Button button16;
    Button button17;
    Button button18;
    Button button19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);

        SoireeDAO soireeDAO = new SoireeDAO(this);

        soireeDAO.open();

        Soiree soiree1 = soireeDAO.selectionnerSoireeByID(1);
        Soiree soiree2 = soireeDAO.selectionnerSoireeByID(2);
        Soiree soiree3 = soireeDAO.selectionnerSoireeByID(3);
        Soiree soiree4 = soireeDAO.selectionnerSoireeByID(4);
        Soiree soiree5 = soireeDAO.selectionnerSoireeByID(5);

        button15.setText(soiree1.getNom());
        button16.setText(soiree2.getNom());
        button17.setText(soiree3.getNom());
        button18.setText(soiree4.getNom());
        button19.setText(soiree5.getNom());

        soireeDAO.close();

    }

    @Override
    protected void onStart (){
        super.onStart();
    }

    @Override
    protected void onResume (){
        super.onResume();
    }

    @Override
    protected void onPause (){
        super.onPause();
    }

    @Override
    protected void onStop (){
        super.onStop();
    }

    @Override
    protected void onRestart (){
        super.onRestart();
    }

    @Override
    protected void onDestroy (){
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }


    public void goSellierActivity(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SellierActivity
        Intent intent = new Intent(this,SellierActivity.class);
        startActivity(intent);
    }

    public void goEventActivity1(View v) {
        Button button = findViewById(R.id.button15);
        String nom = button.getText().toString();

        SoireeDAO soireeDAO = new SoireeDAO(this);

        soireeDAO.open();

        Soiree soiree = soireeDAO.selectionnerSoireeByNom(nom);

        soireeDAO.close();

        int idSoiree = soiree.getId();

        Intent intent=new Intent(this,EventActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        startActivity(intent);
    }

    public void goEventActivity2(View v) {
        Button button = findViewById(R.id.button16);
        String nom = button.getText().toString();

        SoireeDAO soireeDAO = new SoireeDAO(this);

        soireeDAO.open();

        Soiree soiree = soireeDAO.selectionnerSoireeByNom(nom);

        soireeDAO.close();

        int idSoiree = soiree.getId();

        Intent intent=new Intent(this,EventActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        startActivity(intent);
    }

    public void goEventActivity3(View v) {
        Button button = findViewById(R.id.button17);
        String nom = button.getText().toString();

        SoireeDAO soireeDAO = new SoireeDAO(this);

        soireeDAO.open();

        Soiree soiree = soireeDAO.selectionnerSoireeByNom(nom);

        soireeDAO.close();

        int idSoiree = soiree.getId();

        Intent intent=new Intent(this,EventActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        startActivity(intent);
    }

    public void goEventActivity4(View v) {
        Button button = findViewById(R.id.button18);
        String nom = button.getText().toString();

        SoireeDAO soireeDAO = new SoireeDAO(this);

        soireeDAO.open();

        Soiree soiree = soireeDAO.selectionnerSoireeByNom(nom);

        soireeDAO.close();

        int idSoiree = soiree.getId();

        Intent intent=new Intent(this,EventActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        startActivity(intent);
    }

    public void goEventActivity5(View v) {
        Button button = findViewById(R.id.button19);
        String nom = button.getText().toString();

        SoireeDAO soireeDAO = new SoireeDAO(this);

        soireeDAO.open();

        Soiree soiree = soireeDAO.selectionnerSoireeByNom(nom);

        soireeDAO.close();

        int idSoiree = soiree.getId();

        Intent intent=new Intent(this,EventActivity.class);
        intent.putExtra("idSoiree", idSoiree);
        startActivity(intent);
    }

    public void goChecklistActivity(View v) {
        Intent intent=new Intent(this,ChecklistActivity.class);
        startActivity(intent);
    }

    public void goEventCreateActivity(View v) {
        Intent intent=new Intent(this,EventCreateActivity.class);
        startActivity(intent);
    }
}
