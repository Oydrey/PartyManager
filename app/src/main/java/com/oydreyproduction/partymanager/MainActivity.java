package com.oydreyproduction.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
