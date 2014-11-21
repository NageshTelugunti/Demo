package com.example.purpletask;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddUserActivity extends Activity{

	private EditText edtFstName;
	private EditText edtSndName;
	private EditText edtQulification;
	private EditText edtHeight;
	private Button btnAdd;
	DataBaseAdapter dbAdapter;
	private ArrayList<NewUser> neewUserList = new ArrayList<NewUser>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adduser_layout);
		init();
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				NewUser newuser = new NewUser();
				newuser.setFstName(edtFstName.getText().toString());
				newuser.setLastName(edtSndName.getText().toString());
				newuser.setQulification(edtQulification.getText().toString());
				newuser.setHeight(edtHeight.getText().toString());
				neewUserList.add(newuser);
				dbAdapter.insertNewUser(neewUserList);
				finish();
			}
		});
	}
	private void init() {
		dbAdapter = new DataBaseAdapter(AddUserActivity.this);
		edtFstName = (EditText) findViewById(R.id.edt_fst_name);
		edtSndName = (EditText) findViewById(R.id.edt_snd_name);
		edtQulification = (EditText) findViewById(R.id.edt_qualifcation);
		edtHeight = (EditText) findViewById(R.id.edt_height);
		btnAdd = (Button) findViewById(R.id.btn_add);
	}
}
