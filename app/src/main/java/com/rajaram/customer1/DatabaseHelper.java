package com.rajaram.customer1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Customer1.dp";
    public static final String TABLE_NAME = "Customer1_table";
    public static final String NAME = "NAME";
    public static final String AREA = "AREA";
    public static final String STREET = "STREET";
    public static final String CUSTOMERID = "CUSTOMERID";
    public static final String RENT = "RENT";

    public static final String TABLE_PAYMENT ="Payment_table";
    public static final String PAYMENT = "PAYMENT";
    public static final String PREV_BAL ="PEV_BALANCE";
    public static final String DISCOUNT = "DISCOUNT";
    public static final String PAY_TYPE ="PAY_TYPE";
    public static final String DATE_TIME = "DATE_TIME";
    public static final String ACTUAL_AMOUNT ="ACTUAL_AMOUNT" ;



    public static final String TABLE_SETTINGS ="Setting_table";
    public static final String AMOUNT = "AMOUNT";
    public static final String AGENT = "AGENT_NAME";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(NAME TEXT,AREA TEXT,STREET TEXT,CUSTOMERID INTEGER PRIMARY KEY ,RENT INTEGER)");
        db.execSQL("create table " + TABLE_PAYMENT + "(PAYMENT INTEGER,PREV_BALANCE INTEGER,DISCOUNT INTEGER,PAY_TYPE TEXT," +
                "ACTUAL_AMOUNT INTEGER)");
        db.execSQL("create table " + TABLE_SETTINGS + "(AMOUNT INTEGER,AGENT_NAME TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETTINGS);
        onCreate(db);
    }

    public boolean insertData(String name, String area, String street, String cusid,String rent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AREA, area);
        contentValues.put(STREET, street);
        contentValues.put(CUSTOMERID, cusid);
        contentValues.put(RENT, rent);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
        }



    public Cursor getAllData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
}

    public Cursor getData(String cusid) {
        Cursor cursor;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery("select * from " + TABLE_NAME +" WHERE CUSTOMERID=?", new String[] {cusid});
        if(cursor.getCount() > 0) {

            //empName = cursor.getString(cursor.getColumnIndex("EmployeeName"));
        }
        return cursor;
    }

    public boolean updateData(String name, String area, String street, String cusid,String rent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AREA, area);
        contentValues.put(STREET, street);
        contentValues.put(CUSTOMERID, cusid);
        contentValues.put(RENT, rent);

        db.update(TABLE_NAME, contentValues, "CUSTOMERID = ? ", new String[] {cusid});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "CUSTOMERID = ?",new String[] {id});
    }

    public boolean saveData(String amount, String agentname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AMOUNT, amount);
        contentValues.put(AGENT, agentname);
        long result = db.insert(TABLE_SETTINGS, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}