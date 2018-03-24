package com.speeddemonz.slackoff;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by em1909 on 3/23/2018.
 */

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Statistics.db";
    public static final String TABLE_NAME = "stats_table";
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_TOTAL_POINTS = "TOTAL_POINTS";
    public static final String COL_TIME_ON_PHONE = "TIME_ON_PHONE";
    public static final String COL_PERCENT_CLASS_WASTED= "CLASS_TIME_WASTED";
    public static final String COL_TOTAL_CPOINTS= "TOTAL_CPOINTS";

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "Create TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                COL_EMAIL + "TEXT PRIMARY KEY NOT NULL," +
                COL_TOTAL_POINTS + " INTEGER, " +
                COL_TIME_ON_PHONE + " INTEGER, " +
                COL_PERCENT_CLASS_WASTED + " INTEGER, " +
                COL_TOTAL_CPOINTS + " INTEGER " +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        String drop = ("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(drop);
        onCreate(db);
    }
}
