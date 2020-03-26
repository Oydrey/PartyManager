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

        Soiree soiree = new Soiree("Chez goran", "Neuvy", "17/09/2020", "15H", "La teuf !");

        soireeDAO.ajouter(soiree);

        //Soiree soireeFromBD = soireeDAO.selectionnerSoireeByID(1);

        //Toast.makeText(this, soireeFromBD.toString(), Toast.LENGTH_SHORT).show();

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

    public void goEventActivity(View v) {
        Intent intent=new Intent(this,EventActivity.class);
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
