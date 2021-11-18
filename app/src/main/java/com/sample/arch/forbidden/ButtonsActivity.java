package com.sample.arch.forbidden;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        findViewById(R.id.buttonAppCompat).setOnClickListener(this);
        findViewById(R.id.buttonButton).setOnClickListener(this);
        findViewById(R.id.buttonMaterial).setOnClickListener(this);

        // Internal implementation
        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonsActivity.this.finish();
            }
        });
        // Internal implementation with lambdas
        findViewById(R.id.buttonBack).setOnClickListener(view -> ButtonsActivity.this.finish());
        // Class declaration
        findViewById(R.id.buttonBack).setOnClickListener(new ButtonHandler(this));

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Class of button:" + view.getClass().getName(), Toast.LENGTH_LONG).show();
        switch (view.getId()) {
            case (R.id.buttonBack): {
                finish();
            }
            break;
        }
    }

    class ButtonHandler implements View.OnClickListener {

        private Activity mActivity;

        public ButtonHandler(Activity activity) {
            mActivity = activity;
        }

        @Override
        public void onClick(View view) {
            mActivity.finish();
        }
    }
}