package com;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "Accounts.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "user_accounts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "usernames";
    public static final String COLUMN_PASSWORD = "passwords";


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_USERNAME + " TEXT, "+ COLUMN_PASSWORD + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
    }
    void addAccount(String Username, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USERNAME, Username);
        cv.put(COLUMN_PASSWORD, Password);
        long result = db.insert(TABLE_NAME, null,cv);
        if(result == -1)
        {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Added successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
