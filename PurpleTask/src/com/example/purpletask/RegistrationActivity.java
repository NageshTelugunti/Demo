package com.example.purpletask;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends Activity{
	private EditText edtUserName;
	private EditText edtPassword;
	private EditText edtComp;
	private EditText edtVillage;
	private Button btnRegister;
	private DataBaseAdapter dbAdapter;
	private ArrayList<RegisterBean> registerList = new ArrayList<RegisterBean>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration_layout);
		init();
		btnRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				RegisterBean regBean = new RegisterBean();
				regBean.setUserName(edtUserName.getText().toString());
				regBean.setPassword(edtPassword.getText().toString());
				regBean.setCompany(edtComp.getText().toString());
				regBean.setVillage(edtVillage.getText().toString());
				registerList.add(regBean);
				dbAdapter.insertUserData(registerList);
				finish();
			}
		});
	}

	private void init() {
		dbAdapter = new DataBaseAdapter(this);
		edtUserName = (EditText) findViewById(R.id.edt_username);
		edtPassword = (EditText) findViewById(R.id.edt_paswd);
		edtComp     = (EditText) findViewById(R.id.edt_comp);
		edtVillage  = (EditText) findViewById(R.id.edt_village);
		btnRegister = (Button) findViewById(R.id.btn_register);
	}

}
