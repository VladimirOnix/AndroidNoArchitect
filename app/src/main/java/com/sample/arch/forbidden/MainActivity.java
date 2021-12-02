package com.sample.arch.forbidden;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    public static final String BUNDLE_VIEW_TYPE = "BUNDLE_VIEW_TYPE";
    public static final String BUNDLE_RESULT_SELECTED = "BUNDLE_RESULT_SELECTED";
    public static final int ACTIVITY_RESULT = 1001;

    private Button mButtonButtons;
    private Button mButtonFifteenth;
    private Button mButtonCanvas;
    private Button mButtonViews;

    private Spinner mSpinnerViews;
    private ArrayAdapter<?> spinnerViewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonButtons = findViewById(R.id.buttonButtons);
        mButtonFifteenth = findViewById(R.id.buttonFifteenth);
        mButtonCanvas = findViewById(R.id.buttonCanvas);
        mButtonViews = findViewById(R.id.buttonViews);

        mSpinnerViews = findViewById(R.id.spinnerViews);
        spinnerViewsAdapter = ArrayAdapter.createFromResource(this, R.array.view_init_types,
                android.R.layout.simple_spinner_item);
        spinnerViewsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerViews.setAdapter(spinnerViewsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mButtonButtons.setOnClickListener(view -> MainActivity.this.startActivity(new Intent(MainActivity.this, ButtonsActivity.class)));
        mButtonFifteenth.setOnClickListener(view -> MainActivity.this.startActivity(new Intent(MainActivity.this, FifteenthActivity.class)));
        mButtonCanvas.setOnClickListener(view -> MainActivity.this.startActivity(new Intent(MainActivity.this, CanvasActivity.class)));
        mButtonViews.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            intent.putExtra(BUNDLE_VIEW_TYPE, (int) mSpinnerViews.getSelectedItemId());
            MainActivity.this.startActivityForResult(intent,ACTIVITY_RESULT);
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.w(TAG, "RequestCode " + requestCode + " " + "ResultCode " + resultCode);
        if (requestCode == ACTIVITY_RESULT && resultCode == ACTIVITY_RESULT) {
            int result = data.getIntExtra(BUNDLE_RESULT_SELECTED,0);
            Snackbar snackbar = Snackbar.make(mButtonViews,"Returned " + result, BaseTransientBottomBar.LENGTH_SHORT);
            snackbar.show();
        }
    }
}