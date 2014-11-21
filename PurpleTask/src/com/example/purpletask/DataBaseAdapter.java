package com.example.purpletask;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseAdapter {

	public static final String USERNAME = "userName";
	public static final String PASSWOrd = "password";
	public static final String COMPANY = "companyName";
	public static final String VILLAGE = "villageName";
	public static final String REGISTERTABLE = "Register";
	public static final String CREATEREGISTERQUERY = "create table "
			+ REGISTERTABLE + "( " + USERNAME + " varchar(20)," + PASSWOrd
			+ " varchar(20)," + COMPANY + " varchar(20)," + VILLAGE
			+ " varchar(20)" + ");";

	// add user

	public static final String FIRSTNAME = "fstName";
	public static final String SECONDNAME = "secondName";
	public static final String QULAIFICATION = "Qualification";
	public static final String HEIGHT = "HEIGHT";
	public static final String NEWUSERTABLE = "NewUser";
	public static final String CREATENEWUSERQUERY = "create table "
			+ NEWUSERTABLE + "( " + FIRSTNAME + " varchar(20)," + SECONDNAME
			+ " varchar(20)," + QULAIFICATION + " varchar(20)," + HEIGHT
			+ " varchar(20)" + ");";

	public static final String FETCHUSERSQUERY = "select * from "
			+ REGISTERTABLE;
	public static final String NEWUSERQUERY ="select * from " + NEWUSERTABLE;
	private SQLiteDatabase db;
	private DbHelper helper;

	public DataBaseAdapter(Context context) {
		helper = new DbHelper(context);
		db = helper.getWritableDatabase();
	}

	public void insertUserData(ArrayList<RegisterBean> registerList) {
		for (RegisterBean bean : registerList) {
			inserUser(bean);
		}

	}

	private void inserUser(RegisterBean regBean) {
		ContentValues values = new ContentValues();
		values.put(USERNAME, regBean.getUserName());
		values.put(PASSWOrd, regBean.getPassword());
		values.put(COMPANY, regBean.getCompany());
		values.put(VILLAGE, regBean.getVillage());
		db.insert(REGISTERTABLE, null, values);
	}

	public ArrayList<RegisterBean> fetchRegisterUser() {
		ArrayList<RegisterBean> userList = new ArrayList<RegisterBean>();
		Cursor c = db.rawQuery(FETCHUSERSQUERY, null);
		if (c.moveToFirst()) {
			do {
				RegisterBean bean = new RegisterBean();
				bean.setUserName(c.getString(c.getColumnIndex(USERNAME)));
				bean.setPassword(c.getString(c.getColumnIndex(PASSWOrd)));
				bean.setCompany(c.getString(c.getColumnIndex(COMPANY)));
				bean.setVillage(c.getString(c.getColumnIndex(VILLAGE)));
				userList.add(bean);

			} while (c.moveToNext());
		}
		return userList;

	}

	public void insertNewUser(ArrayList<NewUser> neewUserList) {
		for (NewUser user : neewUserList) {
			inserUser(user);
		}

	}

	private void inserUser(NewUser user) {
		ContentValues values = new ContentValues();
		values.put(FIRSTNAME, user.getFstName());
		values.put(SECONDNAME, user.getLastName());
		values.put(QULAIFICATION, user.getQulification());
		values.put(HEIGHT, user.getHeight());
		db.insert(NEWUSERTABLE, null, values);
	}

	public ArrayList<NewUser> fetchNewuserList() {
		ArrayList<NewUser> userList = new ArrayList<NewUser>();
		Cursor c = db.rawQuery(NEWUSERQUERY, null);
		if (c.moveToFirst()) {
			do {
				NewUser bean = new NewUser();
				bean.setFstName(c.getString(c.getColumnIndex(FIRSTNAME)));
				bean.setLastName(c.getString(c.getColumnIndex(SECONDNAME)));
				bean.setQulification(c.getString(c.getColumnIndex(QULAIFICATION)));
				bean.setHeight(c.getString(c.getColumnIndex(HEIGHT)));
				userList.add(bean);

			} while (c.moveToNext());
		}
		return userList;

	}

}
