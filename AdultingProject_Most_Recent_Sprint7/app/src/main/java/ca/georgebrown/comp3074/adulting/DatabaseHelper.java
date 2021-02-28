package ca.georgebrown.comp3074.adulting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "User_Information.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Sign_Up_Info(email text primary key, password text)");
        db.execSQL("Create table Total_Expenses(totalExpenses double primary key)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    //inserting in database
    public boolean insert(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("Sign_Up_Info", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }

    public boolean insertTwo(double totalExpenses) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Total Expenses",totalExpenses);
        long ins = db.insert("Total_Expenses", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }

    //checking if email exists;
    public Boolean chkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Sign_Up_Info where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }



}
