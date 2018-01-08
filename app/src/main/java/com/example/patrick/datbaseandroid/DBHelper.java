package com.example.patrick.datbaseandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.patrick.datbaseandroid.modelo.Student;

/**
 * Created by Patrick on 7/1/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "sqliteDBMultiTbl.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL("CREATE TABLE " + Student.TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, SURNAME TEXT," +
                "DESCRIPTION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));
        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.KEY_Name, name);
        contentValues.put(Student.KEY_SurName, surname);
        contentValues.put(Student.KEY_Description, description);
        long result = db.insert(Student.TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + Student.TABLE_NAME, null);
        return res;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        int i=db.delete(Student.TABLE_NAME,"ID=?",new String[]{id});
        return i;
    }

    public boolean updateData(String id, String name, String surname, String description){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Student.KEY_Name, name);
        contentValues.put(Student.KEY_SurName, surname);
        contentValues.put(Student.KEY_Description, description);
        int result = db.update(Student.TABLE_NAME,contentValues,"ID =?", new String[]{id});
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}
