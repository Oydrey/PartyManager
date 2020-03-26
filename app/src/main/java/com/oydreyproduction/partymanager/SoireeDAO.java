package com.oydreyproduction.partymanager;

import android.content.ContentValues;
import android.database.Cursor;

public class SoireeDAO extends DAOBase {

    public static final String TABLE_SOIREE = "table_soiree";
    public static final String COL_ID_SOIREE = "ID_SOIREE";
    public static final String COL_NOM_SOIREE = "NOM_SOIREE";
    public static final String COL_LIEU = "LIEU";
    public static final String COL_DATE = "DATE";
    public static final String COL_HEURE = "HEURE";
    public static final String COL_DESCRIPTION = "DESCRIPTION";

    public static final String TABLE_CREATE_SOIREE = "CREATE TABLE " + TABLE_SOIREE + " (\n" +
            "\t" + COL_ID_SOIREE + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + COL_NOM_SOIREE + " TEXT NOT NULL,\n" +
            "\t" + COL_LIEU + " TEXT NOT NULL,\n" +
            "\t" + COL_DATE + " TEXT NOT NULL,\n" +
            "\t" + COL_HEURE + " TEXT NOT NULL,\n" +
            "\t" + COL_DESCRIPTION + " TEXT NOT NULL\n" +
            ");";

    public static final String TABLE_DROP_SOIREE = "DROP TABLE IF EXISTS " + TABLE_SOIREE + ";";

    public void ajouter(Soiree soiree){
        ContentValues values = new ContentValues();
        values.put(SoireeDAO.COL_NOM_SOIREE, soiree.getNom());
        values.put(SoireeDAO.COL_LIEU, soiree.getLieu());
        values.put(SoireeDAO.COL_DATE, soiree.getDate());
        values.put(SoireeDAO.COL_HEURE, soiree.getHeure());
        values.put(SoireeDAO.COL_DESCRIPTION, soiree.getDescription());
        mDb.insert(SoireeDAO.TABLE_SOIREE, null, values);
    }

    public void supprimer(int id){
        mDb.delete(TABLE_SOIREE, COL_ID_SOIREE + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifier(Soiree soiree){
        ContentValues values = new ContentValues();
        values.put(COL_NOM_SOIREE, soiree.getNom());
        values.put(COL_LIEU, soiree.getLieu());
        values.put(COL_DATE, soiree.getDate());
        values.put(COL_HEURE, soiree.getHeure());
        values.put(COL_DESCRIPTION, soiree.getDescription());
        mDb.update(TABLE_SOIREE, values, COL_ID_SOIREE + " = ?", new String[] {String.valueOf(soiree.getId())});
    }

    public Soiree selectionnerSoireeByID(int id){
        Cursor c = mDb.rawQuery("select " + COL_NOM_SOIREE + ", " + COL_LIEU + ", " + COL_DATE +
                ", " + COL_HEURE + ", " + COL_DESCRIPTION + " from " + TABLE_SOIREE + " where " + COL_ID_SOIREE + " = ?", new String[] {String.valueOf(id)});
        String nom = c.getString(0);
        String lieu = c.getString(1);
        String date = c.getString(2);
        String heure = c.getString(3);
        String desc = c.getString(4);
        Soiree soiree = new Soiree(nom, lieu, date, heure, desc);
        return soiree;
    }

}
