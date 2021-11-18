package com.sample.arch.forbidden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sample.arch.forbidden.fifteenth.Board;

public class FifteenthActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private Board mBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteenth);

        try {
            mBoard = new Board(4,4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.w(TAG,mBoard.toString());
    }
}