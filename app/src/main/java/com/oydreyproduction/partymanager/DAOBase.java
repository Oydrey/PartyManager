package com.oydreyproduction.partymanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DAOBase {

    protected final static int VERSION = 1;
    protected final static String NOM = "partyManager.db";

    protected SQLiteDatabase mDb = null;
    protected BaseSQLite baseSQLite = null;

    public DAOBase(){

    }

    public DAOBase(Context context){
        this.baseSQLite = new BaseSQLite(context, NOM, null, VERSION);
    }

    public SQLiteDatabase open(){
        mDb = baseSQLite.getWritableDatabase();
        return mDb;
    }

    public void close(){
        mDb.close();
    }

    public SQLiteDatabase getmDb(){
        return mDb;
    }

}
