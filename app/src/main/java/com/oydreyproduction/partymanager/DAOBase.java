package com.oydreyproduction.partymanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public abstract class DAOBase {

    protected final static int VERSION = 1;
    protected final static String NOM = "partyManager.db";

    protected SQLiteDatabase mDb = null;
    protected BaseSQLite baseSQLite = null;

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
