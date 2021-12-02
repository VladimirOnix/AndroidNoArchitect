package com.sample.arch.forbidden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sample.arch.forbidden.canvas.CanvasView;
import com.sample.arch.forbidden.fifteenth.Board;

public class CanvasActivity extends AppCompatActivity {

    CanvasView mCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            mCanvas = new CanvasView(this, new Board(4,4));
            setContentView(mCanvas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}