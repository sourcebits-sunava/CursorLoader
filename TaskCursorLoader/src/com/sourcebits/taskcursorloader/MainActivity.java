package com.sourcebits.taskcursorloader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements LoaderCallbacks<Cursor>
{
	CustomAdapter adapter;
	private static final int CONSTANT = 0;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@SuppressLint("NewApi")
	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) 
	{
		switch (arg0) 
		{
		case CONSTANT:
			return new CursorLoader(getApplicationContext(), ContactsContract.Contacts.CONTENT_URI, null, null, null,
					null);
		default:
			return null;
		}
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) 
	{
		listView = (ListView) findViewById(R.id.listview);
		CustomAdapter adapter = new CustomAdapter(null, arg1);
		listView.setAdapter(adapter);
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}
