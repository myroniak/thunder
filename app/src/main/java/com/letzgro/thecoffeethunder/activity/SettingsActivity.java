package com.letzgro.thecoffeethunder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.letzgro.thecoffeethunder.R;
import com.letzgro.thecoffeethunder.util.PreferencesManager;

public class SettingsActivity extends AppCompatActivity {

    private Button mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mMenu = findViewById(R.id.menu);

        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, MenuActivity.class));
            }
        });
    }
}
