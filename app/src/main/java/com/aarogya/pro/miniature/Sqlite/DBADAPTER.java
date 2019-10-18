package com.aarogya.pro.miniature.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBADAPTER extends SQLiteOpenHelper {

    public DBADAPTER(@Nullable Context context) {
        super(context, "DBNAME", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String query="create table if not exists Mytable(id integer primary key,uname varchar,upass varchar)";
       sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     onCreate(sqLiteDatabase);
    }

    public boolean insertData(String username,String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("uname",username);
        contentValues.put("upass",password);
        sqLiteDatabase.insert("Mytable",null,contentValues);
        return true;
    }
    public Cursor getUploadData(String machNo, String runNo)
    {
        Cursor mCur = null;
        SQLiteDatabase db =this.getWritableDatabase();
        //	String query = "select * from config JOIN calibration ON calib_id= config_calib_id WHERE config.run_no='"+runNo +"'" ;
        String query = "select * from RDPSWITHSECTION  WHERE SECTION_NAME_R='"+runNo +"'" ;
        mCur = db.rawQuery(query, null);
        return  mCur;
    }
    public Cursor getData(){
        Cursor cursor=null;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String q="select * from Mytable";
        cursor=    sqLiteDatabase.rawQuery(q,null);
        return  cursor;
    }
}
