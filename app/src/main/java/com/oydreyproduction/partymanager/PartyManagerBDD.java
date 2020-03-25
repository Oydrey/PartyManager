package com.oydreyproduction.partymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PartyManagerBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "partyManager.db";

    private static final String TABLE_PRODUITS = "table_produits";
    private static final String COL_ID_PRODUIT = "ID_PRODUIT";
    private static final int NUM_COL_ID_PRODUIT = 0;
    private static final String COL_NOM_PRODUIT = "NOM_PRODUIT";
    private static final int NUM_COL_NOM_PRODUIT = 1;
    private static final String COL_QTE_NECESSAIRE = "QTE_NECESSAIRE";
    private static final int NUM_COL_QTE_NECESSAIRE = 2;
    private static final String COL_QTE_ACHETEE = "QTE_ACHETEE";
    private static final int NUM_COL_QTE_ACHETEE = 3;

    private static final String TABLE_SOIREE = "table_soiree";
    private static final String COL_ID_SOIREE = "ID_SOIREE";
    private static final int NUM_COL_ID_SOIREE = 4;
    private static final String COL_NOM_SOIREE = "NOM_SOIREE";
    private static final int NUM_COL_NOM_SOIREE = 5;
    private static final String COL_LIEU = "LIEU";
    private static final int NUM_COL_LIEU = 6;
    private static final String COL_DATE = "DATE";
    private static final int NUM_COL_DATE = 7;
    private static final String COL_HEURE = "HEURE";
    private static final int NUM_COL_HEURE = 8;
    private static final String COL_DESCRIPTION = "DESCRIPTION";
    private static final int NUM_COL_DESCRIPTION = 9;

    private static final String TABLE_LISTE_PRODUITS = "table_liste_produits";
    private static final String COL_FKR_ID_SOIREE = "ID_SOIREE";
    private static final int NUM_COL_FKR_ID_SOIREE = 10;
    private static final String COL_FKR_ID_PRODUIT = "ID_PRODUIT";
    private static final int NUM_COL_FKR_ID_PRODUIT = 11;

    private SQLiteDatabase bdd;

    private BaseSQLite baseSQLite;

    public PartyManagerBDD(Context context) {
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
        values.put(COL_NOM_PRODUIT, produit.getNom());
        values.put(COL_QTE_NECESSAIRE, produit.getQteNecessaire());
        values.put(COL_QTE_ACHETEE, produit.getQteAchetee());
        return bdd.insert(TABLE_PRODUITS, null, values);
    }

    public long insertSoiree(Soiree soiree) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM_SOIREE, soiree.getNom());
        values.put(COL_LIEU, soiree.getLieu());
        values.put(COL_DATE, soiree.getDate());
        values.put(COL_HEURE, soiree.getHeure());
        values.put(COL_DESCRIPTION, soiree.getDescription());
        return bdd.insert(TABLE_SOIREE, null, values);
    }

    public long insertListeProduit(ListeProduit listeProduit) {
        ContentValues values = new ContentValues();
        values.put(COL_FKR_ID_SOIREE, listeProduit.getIdSoiree());
        values.put(COL_FKR_ID_PRODUIT, listeProduit.getIdProduit());
        return bdd.insert(TABLE_LISTE_PRODUITS, null, values);
    }

    public int updateProduit(int id, Produit produit) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM_PRODUIT, produit.getNom());
        values.put(COL_QTE_NECESSAIRE, produit.getQteNecessaire());
        values.put(COL_QTE_ACHETEE, produit.getQteAchetee());
        return bdd.update(TABLE_PRODUITS, values, COL_ID_PRODUIT + " = " + id, null);
    }

    public int updateSoiree(int id, Soiree soiree) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM_SOIREE, soiree.getNom());
        values.put(COL_LIEU, soiree.getLieu());
        values.put(COL_DATE, soiree.getDate());
        values.put(COL_HEURE, soiree.getHeure());
        values.put(COL_DESCRIPTION, soiree.getDescription());
        return  bdd.update(TABLE_SOIREE, values, COL_ID_SOIREE + " = " + id, null);
    }

    public int updateListeProduit(int idSoiree, int idProduit, ListeProduit listeProduit) {
        ContentValues values = new ContentValues();
        values.put(COL_FKR_ID_SOIREE, listeProduit.getIdSoiree());
        values.put(COL_FKR_ID_PRODUIT, listeProduit.getIdProduit());
        return bdd.update(TABLE_LISTE_PRODUITS, values, COL_FKR_ID_SOIREE + " = " + idSoiree + " AND " + COL_FKR_ID_PRODUIT + " = " + idProduit, null);
    }

    public int removeProduitWithID(int id) {
        return bdd.delete(TABLE_PRODUITS, COL_ID_PRODUIT + " = " + id, null);
    }

    public int removeSoireeWithID(int id) {
        return bdd.delete(TABLE_SOIREE, COL_ID_SOIREE + " = " + id, null);
    }

    public int removeListeProduitWithID(int idSoiree, int idProduit) {
        return bdd.delete(TABLE_LISTE_PRODUITS, COL_FKR_ID_SOIREE + " = " + idSoiree + " AND " + COL_FKR_ID_PRODUIT + " = " + idProduit, null);
    }

    public Produit getProduitWithNom(String nom) {
        Cursor c = bdd.query(TABLE_PRODUITS, new String[] {COL_ID_PRODUIT, COL_NOM_PRODUIT, COL_QTE_NECESSAIRE, COL_QTE_ACHETEE},
                COL_NOM_PRODUIT + " LIKE \"" + nom + "\"", null, null, null, null);
        return cursorToProduit(c);
    }

    public Soiree getSoireeWithNom(String nom) {
        Cursor c = bdd.query(TABLE_SOIREE, new String[] {COL_ID_SOIREE, COL_NOM_SOIREE, COL_LIEU, COL_DATE, COL_HEURE, COL_DESCRIPTION},
                COL_NOM_SOIREE + " LIKE \"" + nom + "\"", null, null, null, null);
        return cursorToSoiree(c);
    }

    private Produit cursorToProduit(Cursor c) {
        if (c.getCount() == 0)
            return null;

        c.moveToFirst();
        Produit produit = new Produit();
        produit.setId(c.getInt(NUM_COL_ID_PRODUIT));
        produit.setNom(c.getString(NUM_COL_NOM_PRODUIT));
        produit.setQteNecessaire(c.getInt(NUM_COL_QTE_NECESSAIRE));
        produit.setQteAchetee(c.getInt(NUM_COL_QTE_ACHETEE));
        c.close();
        return produit;
    }

    private Soiree cursorToSoiree(Cursor c) {
        if(c.getCount() == 0)
            return null;

        c.moveToFirst();
        Soiree soiree = new Soiree();
        soiree.setId(c.getInt(NUM_COL_ID_SOIREE));
        soiree.setNom(c.getString(NUM_COL_NOM_SOIREE));
        soiree.setLieu(c.getString(NUM_COL_LIEU));
        soiree.setDate(c.getString(NUM_COL_DATE));
        soiree.setHeure(c.getString(NUM_COL_HEURE));
        soiree.setDescription(c.getString(NUM_COL_DESCRIPTION));
        c.close();
        return soiree;
    }

}
