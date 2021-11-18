package com.sample.arch.forbidden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButtonButtons;
    private Button mButtonFifteenth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonButtons = findViewById(R.id.buttonButtons);
        mButtonFifteenth = findViewById(R.id.buttonFifteenth);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mButtonButtons.setOnClickListener(view -> MainActivity.this.startActivity(new Intent(MainActivity.this, ButtonsActivity.class)));
        mButtonFifteenth.setOnClickListener(view -> MainActivity.this.startActivity(new Intent(MainActivity.this, FifteenthActivity.class)));
    }
}