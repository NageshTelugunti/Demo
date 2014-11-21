package com.example.purpletask;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NewUserAdapter extends BaseAdapter  {
	private Context context;
	private ArrayList<NewUser> userList, refList = new ArrayList<NewUser>();
	private LayoutInflater inflater;

	public NewUserAdapter(Context context, ArrayList<NewUser> userList) {
		this.context  = context;
		this.userList = userList;
		
		this.refList.addAll(userList);
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return userList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return userList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int pos, View convertview, ViewGroup arg2) {
		if (convertview == null) {
			convertview = getConverView();
		}
		
		updateConvertView(convertview, pos);
		return convertview;
	}

	private void updateConvertView(View convertview, int pos) {
		ViewHolder holder = (ViewHolder) convertview.getTag();
		holder.fName.setText(userList.get(pos).getFstName());
		holder.sName.setText(userList.get(pos).getLastName());
		holder.qulification.setText(userList.get(pos).getQulification());
		holder.height.setText(userList.get(pos).getHeight());

	}

	private View getConverView() {
		ViewHolder holder = new ViewHolder();
		View view = inflater.inflate(R.layout.item_row, null);
		holder.fName = (TextView) view.findViewById(R.id.txtname);
		holder.sName = (TextView) view.findViewById(R.id.txtlName);
		holder.qulification = (TextView) view.findViewById(R.id.txtQulif);
		holder.height = (TextView) view.findViewById(R.id.txthgt);
		view.setTag(holder);
		return view;
	}

	private class ViewHolder {
		private TextView fName;
		private TextView sName;
		private TextView qulification;
		private TextView height;
	}

	public void filter(String val) {
		userList.clear();
		
		for(int i= 0; i<refList.size(); i++){
			if(refList.get(i).getFstName().contains(val)){
				userList.add(refList.get(i));
			}
		}
		
		notifyDataSetChanged();
	}
}
