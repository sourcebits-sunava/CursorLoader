package com.sourcebits.taskcursorloader;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

@SuppressLint("NewApi")
public class MainActivity extends ListActivity implements LoaderCallbacks<Cursor>
{
	
	private static final int CONSTANT = 0;
	ListView listView;
	String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
    String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
    ListAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mAdapter = new SimpleCursorAdapter(
				MainActivity.this,
		        android.R.id.list, 
		        null,
		        new String[] { Contacts.DISPLAY_NAME, Contacts.CONTACT_STATUS },
		        new int[] { android.R.id.text1, android.R.id.text2 }, 
		        0);
		
		setListAdapter(mAdapter);
		getLoaderManager().initLoader(CONSTANT, null, this);
	}

	@SuppressLint("NewApi")
	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) 
	{
		Uri CONTENT_URI = Phone.CONTENT_URI;
		switch (arg0) 
		{
		case CONSTANT:
			return new CursorLoader(getApplicationContext(), CONTENT_URI, null, null, null, null);
		default:
			return null;
		}
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) 
	{
		/*listView = (ListView) findViewById(R.id.listview);
		CustomAdapter adapter = new CustomAdapter(null, arg1);
		listView.setAdapter(adapter);*/
		
		
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}
