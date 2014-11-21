package com.example.purpletask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
	public static final String DATABASENAME ="MyDataBase.db";
	public static final int VERSION = 1;

	public DbHelper(Context context) {
		super(context, DATABASENAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DataBaseAdapter.CREATEREGISTERQUERY);
		db.execSQL(DataBaseAdapter.CREATENEWUSERQUERY);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("Drop table" + DataBaseAdapter.REGISTERTABLE + "if exist");
		db.execSQL("Drop table" + DataBaseAdapter.CREATENEWUSERQUERY + "if exist");

		onCreate(db);
	}

}
