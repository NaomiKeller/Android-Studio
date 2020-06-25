package com.murach.dailyplanner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import java.util.prefs.Preferences;


public class DailyPlannerFragment extends Fragment
 {

    // define variables for the widgets
    private EditText EditText1;
    private EditText EditText2;
    private EditText EditText3;
    private EditText EditText4;
    private EditText EditText5;
    private Button Button;

    // set up preferences
    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);            
        // set the default values for the preferences
        PreferenceManager.setDefaultValues(getActivity(), R.xml.preferences, false);

        // get default SharedPreferences object
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // tell the Fragment that we have an OptionsMenu
        setHasOptionsMenu(true);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily_planner, container, false);

        // get references to the widgets
        EditText1 = (EditText) view.findViewById(R.id.editText1);
        EditText2 = (EditText) view.findViewById(R.id.editText2);
        EditText3 = (EditText) view.findViewById(R.id.editText3);
        EditText4 = (EditText) view.findViewById(R.id.editText4);
        EditText5 = (EditText) view.findViewById(R.id.editText5);
        Button = (Button) view.findViewById(R.id.button);

        // Setting listener for button to reset the EditTexts

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText1.getText().clear();
                EditText2.getText().clear();
                EditText3.getText().clear();
                EditText4.getText().clear();
                EditText5.getText().clear();
            }
        });

        // return the View for the layout
        return view;
    }


    // begin option menu
    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // attempt to get an instance of the SettingsFragment object
        SettingsActivity settingsFragment = (SettingsFragment) getFragmentManager()
                .findFragmentById(R.id.settings_fragment);

        // display the appropriate menu
        if (settingsFragment == null) {
            // SettingsFragment is not in the layout
            inflater.inflate(R.menu.fragment_daily_planner, menu);
        } else {
            // SettingsFragment is in the layout
            inflater.inflate(R.menu.fragment_daily_planner_twopane, menu);
        }
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_daily_planner, menu) ;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_settings:
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;
        case R.id.menu_about:
            startActivity(new Intent(getActivity(), AboutActivity.class));
            return true;

        default:
            return super.onOptionsItemSelected(item);
        }
    }
}