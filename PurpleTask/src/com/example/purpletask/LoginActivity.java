package com.example.purpletask;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	private EditText edtUserName;
	private EditText edtPassword;
	private Button btnLogin;
	private Button btnRegister;
	private DataBaseAdapter dbAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		initLayout();
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			ArrayList<RegisterBean> regUsrList = 	dbAdapter.fetchRegisterUser();
			for(int i =0;i<regUsrList.size();i++){
				if(!regUsrList.get(i).getUserName().equals(edtUserName.getText().toString()) && !regUsrList.get(i).getPassword().equals(edtPassword.getText().toString())){
					Toast.makeText(LoginActivity.this,"User Already exist",Toast.LENGTH_LONG).show();
					break;
				}else{
					Intent intent = new Intent(LoginActivity.this,UsersListActivity.class);
					startActivity(intent);
					break;
				}
			}
				
			}
		});
		btnRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intent);
			}
		});
	}

	private void initLayout() {
		dbAdapter = new DataBaseAdapter(LoginActivity.this);
		edtUserName = (EditText) findViewById(R.id.edt_username);
		edtPassword = (EditText) findViewById(R.id.edt_pswd);
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnRegister = (Button) findViewById(R.id.btn_register);
	}

}
