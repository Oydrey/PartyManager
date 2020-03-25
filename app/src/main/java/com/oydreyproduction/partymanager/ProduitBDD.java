package com.oydreyproduction.partymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProduitBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "partyManager.db";

    private static final String TABLE_PRODUITS = "table produits";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "NOM";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_QTE_NECESSAIRE = "QTE_NECESSAIRE";
    private static final int NUM_COL_QTE_NECESSAIRE = 2;
    private static final String COL_QTE_ACHETEE = "QTE_ACHETEE";
    private static final int NUM_COL_QTE_ACHETEE = 3;

    private SQLiteDatabase bdd;

    private BaseSQLite baseSQLite;

    public ProduitBDD(Context context) {
        baseSQLite = new BaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {
        bdd = baseSQLite.getWritableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public long insertProduit(Produit produit) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM, produit.getNom());
        values.put(COL_QTE_NECESSAIRE, produit.getQteNecessaire());
        values.put(COL_QTE_ACHETEE, produit.getQteAchetee());
        return bdd.insert(TABLE_PRODUITS, null, values);
    }

    public int updateProduit(int id, Produit produit) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM, produit.getNom());
        values.put(COL_QTE_NECESSAIRE, produit.getQteNecessaire());
        values.put(COL_QTE_ACHETEE, produit.getQteAchetee());
        return bdd.update(TABLE_PRODUITS, values, COL_ID + " = " + id, null);
    }

    public int removeProduitWithID(int id) {
        return bdd.delete(TABLE_PRODUITS, COL_ID + " = " + id, null);
    }

    public Produit getProduitWithNom(String nom) {
        Cursor c = bdd.query(TABLE_PRODUITS, new String[] {COL_ID, COL_NOM, COL_QTE_NECESSAIRE, COL_QTE_ACHETEE},
                COL_NOM + " LIKE \"" + nom + "\"", null, null, null, null);
        return cursorToProduit(c);
    }

    private Produit cursorToProduit(Cursor c) {
        if (c.getCount() == 0)
            return null;

        c.moveToFirst();
        Produit produit = new Produit();
        produit.setId(c.getInt(NUM_COL_ID));
        produit.setNom(c.getString(NUM_COL_NOM));
        produit.setQteNecessaire(c.getInt(NUM_COL_QTE_NECESSAIRE));
        produit.setQteAchetee(c.getInt(NUM_COL_QTE_ACHETEE));
        c.close();
        return produit;
    }

}
