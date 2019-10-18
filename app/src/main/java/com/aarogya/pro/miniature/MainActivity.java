package com.aarogya.pro.miniature;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.aarogya.pro.miniature.Sqlite.DBADAPTER;

public class MainActivity extends AppCompatActivity {
    DBADAPTER  dbadapter=new DBADAPTER(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbadapter.insertData("username","password");
        dbadapter.insertData("myuser","mypassword");
        Cursor cur = dbadapter.getData();
        while (cur.moveToNext()){
            cur.getString(1);
            cur.getString(2);
        }
   }
}
