package com.oydreyproduction.partymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class ProduitDAO extends DAOBase {

    public static final String TABLE_PRODUIT = "table_produit";
    public static final String COL_ID_PRODUIT = "ID_PRODUIT";
    public static final String COL_NOM_PRODUIT = "NOM_PRODUIT";
    public static final String COL_QTE_NECESSAIRE = "QTE_NECESSAIRE";
    public static final String COL_QTE_ACHETEE = "QTE_ACHETEE";

    public static final String TABLE_CREATE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT + " (\n" +
            "\t" + COL_ID_PRODUIT + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + COL_NOM_PRODUIT + " TEXT NOT NULL,\n" +
            "\t" + COL_QTE_NECESSAIRE + " INTEGER,\n" +
            "\t" + COL_QTE_ACHETEE + " INTEGER DEFAULT 0\n" +
            ");";

    public static final String TABLE_DROP_PRODUIT = "DROP TABLE IF EXISTS " + TABLE_PRODUIT + ";";

    public ProduitDAO(Context context){
        this.baseSQLite = new BaseSQLite(context, NOM, null, VERSION);
    }

    public void ajouter(Produit produit){
        ContentValues values = new ContentValues();
        values.put(ProduitDAO.COL_NOM_PRODUIT, produit.getNom());
        values.put(ProduitDAO.COL_QTE_NECESSAIRE, produit.getQteNecessaire());
        values.put(ProduitDAO.COL_QTE_ACHETEE, produit.getQteAchetee());
        mDb.insert(ProduitDAO.TABLE_PRODUIT, null, values);
    }

    public Produit selectionnerProduitByID(int id){
        Cursor c = mDb.rawQuery("select " + COL_NOM_PRODUIT + ", " + COL_QTE_NECESSAIRE + ", " + COL_QTE_ACHETEE +
                " from " + TABLE_PRODUIT + " where " + COL_ID_PRODUIT + " = " + id, null);
        //Log.v("Je suis la", c.toString());
        if(c != null && c.moveToFirst()){
            String nom = c.getString(0);
            int qteNecessaire = c.getInt(1);
            int qteAchetee = c.getInt(2);
            c.close();
            Produit produit = new Produit(nom, qteNecessaire, qteAchetee);
            //Log.v("Je suis la", "selectionnerProduitByID dans if");
            return produit;
        }
        else{
            //Log.v("Je suis la", "selectionnerProduitByID dans else");
            return new Produit("vide", 0, 0);
        }
    }

    public Produit selectionnerProduitByNom(String nom){
        Cursor c = mDb.rawQuery("select " + COL_ID_PRODUIT + ", " + COL_QTE_NECESSAIRE + ", " + COL_QTE_ACHETEE +
                " from " + TABLE_PRODUIT + " where " + COL_NOM_PRODUIT + " = \"" + nom + "\"", null);
        if(c != null && c.moveToFirst()){
            int id = c.getInt(0);
            int qteNecessaire = c.getInt(1);
            int qteAchetee = c.getInt(2);
            c.close();
            Produit produit = new Produit(nom, qteNecessaire, qteAchetee);
            return produit;
        }
        else{
            return new Produit("vide", 0, 0);
        }
    }

    public int getIdByProduit(Produit produit){
        String nom = produit.getNom();

        Cursor c = mDb.rawQuery("select " + COL_ID_PRODUIT + " from " + TABLE_PRODUIT
                + " where " + COL_NOM_PRODUIT + " = \"" + nom + "\"", null);
        if(c != null && c.moveToFirst()){
            int id = c.getInt(0);
            c.close();
            return id;
        }
        else{
            return -1;
        }
    }

}
