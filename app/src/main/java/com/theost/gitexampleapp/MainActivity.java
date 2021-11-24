package com.theost.gitexampleapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // My editions

        findViewById(R.id.button).setOnClickListener(view -> showToast());
    }

    private void showToast() {
        Toast.makeText(this, R.string.text, Toast.LENGTH_SHORT).show();
    }

}