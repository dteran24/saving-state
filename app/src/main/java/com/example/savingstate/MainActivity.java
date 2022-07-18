package com.example.savingstate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText prefsEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefsEditText = findViewById(R.id.eText);
    }
    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {
        //get the data from etPrefs
        String prefs = prefsEditText.getText().toString();
        //create a file
        SharedPreferences preferences = getSharedPreferences("prefs_file_name",MODE_PRIVATE);
        //open the file in edit mode
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString("pkey",prefs);
        //save the file
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    private void restoreData() {
        //read the data from the file
        SharedPreferences  preferences = getSharedPreferences("prefs_file_name",MODE_PRIVATE);
        String prefs = preferences.getString("pkey","");
        //put it back into the edittext
        prefsEditText.setText(prefs);
    }
}
