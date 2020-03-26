package com.oydreyproduction.partymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ListeProduitDAO extends DAOBase {

    public static final String TABLE_LISTE_PRODUIT = "table_liste_produit";
    public static final String COL_FKR_ID_PRODUIT = "ID_PRODUIT";
    public static final String COL_FKR_ID_SOIREE = "ID_SOIREE";

    public static final String TABLE_CREATE_LISTE_PRODUIT = "CREATE TABLE " + TABLE_LISTE_PRODUIT + " (\n" +
            "\t" + COL_FKR_ID_SOIREE + " INTEGER,\n" +
            "\t" + COL_FKR_ID_PRODUIT + " INTEGER,\n" +
            "\tPRIMARY KEY (" + COL_FKR_ID_SOIREE + ", " + COL_FKR_ID_PRODUIT + ") AUTOINCREMENT,\n" +
            "\tFOREIGN KEY (" + COL_FKR_ID_SOIREE + ") REFERENCES table_soiree (" + COL_FKR_ID_SOIREE + "),\n" +
            "\tFOREIGN KEY (" + COL_FKR_ID_PRODUIT + ") REFERENCES table_produit (" + COL_FKR_ID_PRODUIT + ")\n" +
            ");";

    public static final String TABLE_DROP_LISTE_PRODUIT = "DROP TABLE IF EXISTS " + TABLE_LISTE_PRODUIT + ";";

    public ListeProduitDAO(Context context){
        this.baseSQLite = new BaseSQLite(context, NOM, null, VERSION);
    }

    public void ajouter(ListeProduit listeProduit){
        ContentValues values = new ContentValues();
        values.put(ListeProduitDAO.COL_FKR_ID_PRODUIT, listeProduit.getIdProduit());
        values.put(ListeProduitDAO.COL_FKR_ID_SOIREE, listeProduit.getIdSoiree());
        mDb.insert(ListeProduitDAO.TABLE_LISTE_PRODUIT, null, values);
    }

    public void supprimer(int idSoiree, int idProduit){
        mDb.delete(TABLE_LISTE_PRODUIT, COL_FKR_ID_PRODUIT + " = " + idProduit + " AND " + COL_FKR_ID_SOIREE + " = " + idSoiree, null);
    }

    public void modifier(ListeProduit listeProduit){
        ContentValues values = new ContentValues();
        values.put(COL_FKR_ID_PRODUIT, listeProduit.getIdProduit());
        values.put(COL_FKR_ID_SOIREE, listeProduit.getIdSoiree());
        mDb.update(TABLE_LISTE_PRODUIT, values, COL_FKR_ID_PRODUIT + " = " + listeProduit.getIdProduit() + " AND " + COL_FKR_ID_SOIREE + " = " + listeProduit.getIdSoiree(), null);
    }

    public ListeProduit[] selectionnerListeProduitByIDSoiree(int idSoiree){
        Cursor c = mDb.rawQuery("select " + COL_FKR_ID_PRODUIT + " from " + TABLE_LISTE_PRODUIT +
                " where " + COL_FKR_ID_SOIREE + " = " + idSoiree, null);
        int[] idProduit = new int[10];
        int i=0;
        if(c != null){
            for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
                idProduit[i] = c.getInt(i);
                i+=1;
            }
            ListeProduit[] listeProduit = new ListeProduit[10];
            for(int j=0; j < idProduit.length; j++){
                listeProduit[j] = new ListeProduit(idProduit[j], idSoiree);
            }
            return listeProduit;
        }
        else{
            return null;
        }
    }

}
