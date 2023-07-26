package com.onedaydent.gigongrequest.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String TAG = DatabaseHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static SQLiteDatabase db = null;
    private static DatabaseHelper instance = null;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
        onUpgrade(db, DATABASE_VERSION, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context){
        if(instance == null) instance = new DatabaseHelper(context);
        return instance;
    }

    public static DatabaseHelper getInstance(){
        return instance;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TB_MEMBER (id INTEGER PRIMARY KEY AUTOINCREMENT, mb_no INTEGER DEFAULT 0, mb_name TEXT default '', mb_hall INTEGER DEFAULT 0, mb_department TEXT default '')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TB_MEMBER");
        onCreate(db);
    }
}
