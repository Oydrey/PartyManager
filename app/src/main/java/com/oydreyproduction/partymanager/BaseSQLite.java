package com.oydreyproduction.partymanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseSQLite extends SQLiteOpenHelper {

    private static final String TABLE_PRODUIT = "table_produit";
    private static final String COL_ID_PRODUIT = "ID_PRODUIT";
    private static final String COL_NOM_PRODUIT = "NOM_PRODUIT";
    private static final String COL_QTE_NECESSAIRE = "QTE_NECESSAIRE";
    private static final String COL_QTE_ACHETEE = "QTE_ACHETEE";

    private static final String TABLE_SOIREE = "table_soiree";
    private static final String COL_ID_SOIREE = "ID_SOIREE";
    private static final String COL_NOM_SOIREE = "NOM_SOIREE";
    private static final String COL_LIEU = "LIEU";
    private static final String COL_DATE = "DATE";
    private static final String COL_HEURE = "HEURE";
    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String TABLE_LISTE_PRODUIT = "table_liste_produit";
    private static final String COL_FKR_ID_PRODUIT = "ID_PRODUIT";
    private static final String COL_FKR_ID_SOIREE = "ID_SOIREE";

    private static final String TABLE_PRODUIT_DROP = "DROP TABLE IF EXISTS " + TABLE_PRODUIT + ";";
    private static final String TABLE_SOIREE_DROP = "DROP TABLE IF EXISTS " + TABLE_SOIREE + ";";
    private static final String TABLE_LISTE_PRODUIT_DROP = "DROP TABLE IF EXISTS " + TABLE_LISTE_PRODUIT + ";";

    private static final String TABLE_CREATE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT + " (\n" +
            "\t" + COL_ID_PRODUIT + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + COL_NOM_PRODUIT + " TEXT NOT NULL,\n" +
            "\t" + COL_QTE_NECESSAIRE + " INTEGER,\n" +
            "\t" + COL_QTE_ACHETEE + " INTEGER DEFAULT 0\n" +
            ");";

    private static final String TABLE_CREATE_SOIREE = "CREATE TABLE " + TABLE_SOIREE + " (\n" +
            "\t" + COL_ID_SOIREE + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + COL_NOM_SOIREE + " TEXT NOT NULL,\n" +
            "\t" + COL_LIEU + " TEXT NOT NULL,\n" +
            "\t" + COL_DATE + " TEXT NOT NULL,\n" +
            "\t" + COL_HEURE + " TEXT NOT NULL,\n" +
            "\t" + COL_DESCRIPTION + " TEXT NOT NULL\n" +
            ");";

    private static final String TABLE_CREATE_LISTE_PRODUIT = "CREATE TABLE " + TABLE_LISTE_PRODUIT + " (\n" +
            "\t" + COL_FKR_ID_SOIREE + " INTEGER,\n" +
            "\t" + COL_FKR_ID_PRODUIT + " INTEGER,\n" +
            "\tPRIMARY KEY (" + COL_FKR_ID_SOIREE + ", " + COL_FKR_ID_PRODUIT + "),\n" +
            "\tFOREIGN KEY (" + COL_FKR_ID_SOIREE + ") REFERENCES table_soiree (" + COL_FKR_ID_SOIREE + "),\n" +
            "\tFOREIGN KEY (" + COL_FKR_ID_PRODUIT + ") REFERENCES table_produit (" + COL_FKR_ID_PRODUIT + ")\n" +
            ");";

    public BaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_PRODUIT);
        db.execSQL(TABLE_CREATE_SOIREE);
        db.execSQL(TABLE_CREATE_LISTE_PRODUIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_PRODUIT_DROP);
        db.execSQL(TABLE_SOIREE_DROP);
        db.execSQL(TABLE_LISTE_PRODUIT_DROP);
        onCreate(db);
    }

}
