package com.example.purpletask;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class UsersListActivity extends Activity{
	private Button btnSearch;
	private Button btnexit;
	private Button btnAdduser;
	private Button btnGrid;
	private ListView usersListview;
	private GridView userGrid;
	private DataBaseAdapter dbAdapter;
	private ArrayList<NewUser> userList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reg_userlist_layout);
		init();
		
		btnAdduser.setOnClickListener(new AddNewUserOnClickListenrer());
		btnSearch.setOnClickListener(new SearchClickListener());
		btnGrid.setOnClickListener(new GridViewClickListener());
		
	}
	private void init() {
		dbAdapter = new DataBaseAdapter(UsersListActivity.this);
	 btnSearch = (Button) findViewById(R.id.btn_search);
	 btnAdduser = (Button) findViewById(R.id.btn_adduser);
	 btnexit =  (Button) findViewById(R.id.btn_exit);
	 btnGrid = (Button) findViewById(R.id.btn_grid);
	 usersListview = (ListView) findViewById(R.id.user_list);
	 userGrid = (GridView) findViewById(R.id.grid_view);
	}
	@Override
	protected void onResume() {
		super.onResume();
		userList = dbAdapter.fetchNewuserList();
		NewUserAdapter adapter = new NewUserAdapter(this,userList);
		usersListview.setAdapter(adapter);
	}

	private class AddNewUserOnClickListenrer implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(UsersListActivity.this,AddUserActivity.class);
			startActivity(intent);
		}
	}
	private class SearchClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent i = new Intent(UsersListActivity.this,SeachListActivity.class);
			startActivity(i);
		}
		
	}
	
	private class GridViewClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			userGrid.setVisibility(View.VISIBLE);
			usersListview.setVisibility(View.GONE);
			GridAdapter adapter = new GridAdapter(UsersListActivity.this,userList);
			userGrid.setAdapter(adapter);
			
		}
		
	}
}
