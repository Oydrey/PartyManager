package com.oydreyproduction.partymanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseSQLite extends SQLiteOpenHelper {

    private static final String TABLE_PRODUITS = "table_produits";
    private static final String COL_ID = "ID";
    private static final String COL_NOM = "NOM";
    private static final String COL_QTE_NECESSAIRE = "QTE_NECESSAIRE";
    private static final String COL_QTE_ACHETEE = "QTE_ACHETEE";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_PRODUITS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT NOT NULL, "
            + COL_QTE_NECESSAIRE + " INTEGER NOT NULL, " + COL_QTE_ACHETEE + " INTEGER NOT NULL);";

    public BaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_PRODUITS + ";");
        onCreate(db);
    }

}
