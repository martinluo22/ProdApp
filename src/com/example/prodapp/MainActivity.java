package com.example.prodapp;

import android.app.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;

public class MainActivity extends Activity {

	public static EditText editTxt;

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			View v = getCurrentFocus();
			if (v instanceof EditText) {
				Rect outRect = new Rect();
				v.getGlobalVisibleRect(outRect);
				if (!outRect.contains((int) event.getRawX(),
						(int) event.getRawY())) {
					
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
					v.clearFocus();
				}
			}
		}
		return super.dispatchTouchEvent(event); 
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
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
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_main,
					container, false);
			RelativeLayout layoutMenu = (RelativeLayout) rootView
					.findViewById(R.id.layoutMenu);

			ImageButton taskButton = (ImageButton) rootView
					.findViewById(R.id.taskButton);
			taskButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent("com.example.prodapp.Tasks");
					startActivity(intent);
				}

			});

			ImageButton settingsButton = (ImageButton) rootView
					.findViewById(R.id.settingsButton);
			settingsButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent("com.example.prodapp.Settings");
					startActivity(intent);
				}

			});

			ImageButton efficiencyButton = (ImageButton) rootView
					.findViewById(R.id.efficiencyButton);
			efficiencyButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
							"com.example.prodapp.Efficiencies");
					startActivity(intent);

				}

			});

			editTxt = (EditText) rootView.findViewById(R.id.new_task);
			final CharSequence hintText = editTxt.getHint();

			editTxt.setOnFocusChangeListener(new OnFocusChangeListener() {

				@Override
				public void onFocusChange(View v, boolean hasFocus) {

					if (hasFocus) {
						editTxt.setGravity(Gravity.LEFT);
						editTxt.setHint("");
						editTxt.setCursorVisible(true);
					} 
					else {
							editTxt.setGravity(Gravity.CENTER);
							editTxt.setHint(hintText);
							editTxt.setCursorVisible(false);											
					}
				}
			});
		
			/*editTxt.setOnEditorActionListener(new OnEditorActionListener() {
				@Override
				public boolean onEditorAction(TextView view, int actionId,
						KeyEvent event) {
					int result = actionId & EditorInfo.IME_MASK_ACTION;
					switch (result) {
					case EditorInfo.IME_ACTION_DONE:
						if (editTxt.getText().length() == 0) {
							editTxt.setGravity(Gravity.CENTER_HORIZONTAL);
						}
						editTxt.setHint(hintText);
						editTxt.clearFocus();
						break;
					}
					InputMethodManager imm = (InputMethodManager) rootView
							.getContext().getSystemService(
									Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
					return true;
				}
			}); */

			return rootView;
		}

	}
}