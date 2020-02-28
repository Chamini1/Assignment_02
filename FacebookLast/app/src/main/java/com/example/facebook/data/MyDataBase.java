package com.example.facebook.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class MyDataBase extends SQLiteOpenHelper {

    // database name and version
    public static final String DB_NAME = "fb.db";
    public static final int DB_VERSION = 1;

    // student table name and colomn names
    public static final String STUDENT_TABLE = "student";

    private static final String STUDENT_NAME = "name";
    private static final String STUDENT_AGE = "age";
    private static final String STUDENT_MARKS = "marks";

    private static final String CREATE_STUDENT_TABLE = "CREATE TABLE " + STUDENT_TABLE + "(" +
            STUDENT_NAME + " VARCHAR(120) ," +
            STUDENT_AGE + "INTEGER," +
            STUDENT_MARKS + "INTEGER );";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + STUDENT_TABLE;

    //private static final String SELECT_STUDENT = "SELECT * FROM STUDENT";


    public MyDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
        Log.d(TAG, "onCreate:" + "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean insertData(String Name, String Age, String Marks) {
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(STUDENT_NAME, Name);
            contentValues.put(STUDENT_AGE, Age);
            contentValues.put(STUDENT_MARKS, Marks);
            long result = db.insert(STUDENT_TABLE, null, contentValues);
            if (result == -1)
                return true;
        }
        return false;
    }

    public Cursor retrieveData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);
        return res;
    }




}











