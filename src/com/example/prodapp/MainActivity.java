package com.example.prodapp;

import android.app.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			
			RelativeLayout layoutMenu = (RelativeLayout)rootView.findViewById(R.id.layoutMenu);
			
			ImageButton taskButton = (ImageButton)rootView.findViewById(R.id.taskButton);
			taskButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v)   {
					Intent intent = new Intent ("com.example.prodapp.Tasks");
					startActivity(intent);
				}
				
			});
			
			ImageButton settingsButton = (ImageButton)rootView.findViewById(R.id.settingsButton);
			settingsButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent ("com.example.prodapp.Settings");
					startActivity(intent);
				}
				
			});
			
			ImageButton efficiencyButton = (ImageButton)rootView.findViewById(R.id.efficiencyButton);
			efficiencyButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent ("com.example.prodapp.Efficiencies");
					startActivity(intent);
					
				}
				
			});
			
			
			return rootView;
		}
	}
}