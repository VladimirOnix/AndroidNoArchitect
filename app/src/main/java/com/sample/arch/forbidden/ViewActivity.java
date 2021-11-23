package com.sample.arch.forbidden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ViewActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        int viewType = bundle.getInt(MainActivity.BUNDLE_VIEW_TYPE,0);
        Log.w(TAG,"Init view param " + viewType);

        switch(viewType){
            case(0):{
                // instead of passing xml
                setContentView(R.layout.activity_view);
            }break;
            case(1):{
                // you can pass the View
                Button view = new Button(this);
                view.setText(R.string.app_name);
                setContentView(view);
            }break;
            case(2):{
                // or View group
                LinearLayout group = new LinearLayout(this);
                group.setOrientation(LinearLayout.VERTICAL);
                for(int i=0;i<5;i++){
                    Button button = new Button(this);
                    button.setText("Result:" + i);
                    int finalI = i;
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra(MainActivity.BUNDLE_RESULT_SELECTED, finalI);
                            setResult(MainActivity.ACTIVITY_RESULT,intent);
                            finish();
                        }
                    });
                    group.addView(button);
                }
                setContentView(group);
            }break;
        }
    }
}