package com.example.purpletask;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

public class SeachListActivity extends Activity {
	private EditText edtSearch;
	private ListView searchList;
	private ArrayList<NewUser> userList;
	private DataBaseAdapter dbAdapter;
	NewUserAdapter adapter ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		
		edtSearch = (EditText) findViewById(R.id.edtSearch);
		searchList = (ListView) findViewById(R.id.seachList);
		
		dbAdapter = new DataBaseAdapter(this);
		userList = dbAdapter.fetchNewuserList();

		 adapter = new NewUserAdapter(this, userList);
		searchList.setAdapter(adapter);
		
		edtSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String val = s.toString();
				adapter.filter(val);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});

	}

}
