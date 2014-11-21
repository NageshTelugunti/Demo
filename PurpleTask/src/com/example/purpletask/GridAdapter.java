package com.example.purpletask;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter{
	private Context context;
	private ArrayList<NewUser> newList;
	private LayoutInflater inflater;

	public GridAdapter(Context context,
			ArrayList<NewUser> userList) {
		this.context = context;
		newList = userList;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return newList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return newList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		if(convertView == null){
			convertView = getConvertView();
		}
		updateConvertView(arg0,convertView);
		return convertView;
	}

	private void updateConvertView(int arg0, View convertView) {
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.txtName.setText(newList.get(arg0).getFstName());
	}

	private View getConvertView() {
		ViewHolder holder = new ViewHolder();
		View view = inflater.inflate(R.layout.gridlayout,null);
		holder.txtName = (TextView)view.findViewById(R.id.grid_item_label);
		view.setTag(holder);
		return view;
	}

	private class ViewHolder{
		private TextView txtName;
	}
}
