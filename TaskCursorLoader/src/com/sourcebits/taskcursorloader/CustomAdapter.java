package com.sourcebits.taskcursorloader;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomAdapter extends CursorAdapter {

	@SuppressWarnings("deprecation")
	public CustomAdapter(Context context, Cursor c) 
	{
		super(context, c);
		// TODO Auto-generated constructor stub
	}

	public View newView(Context context, Cursor cursor, ViewGroup parent) 
	{

		return LayoutInflater.from(context).inflate(R.layout.contact_cp, parent, false);
	}

	public void bindView(View view, Context context, Cursor cursor) {

		TextView name = (TextView) view.findViewById(R.id.name);
		TextView number = (TextView) view.findViewById(R.id.number);
		String contactname = cursor.getString(cursor.getColumnIndexOrThrow("ContactsContract.Contacts.DISPLAY_NAME"));
		String contactnumber = cursor.getString(cursor.getColumnIndexOrThrow("ContactsContract.CommonDataKinds.Phone.NUMBER"));

		// Populate fields with extracted properties
		name.setText(contactname);
		number.setText(String.valueOf(contactnumber));

	}
}
