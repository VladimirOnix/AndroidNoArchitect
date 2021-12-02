package com.sample.arch.forbidden;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.sample.arch.forbidden.adapter.ListAdapter;

public class AdapterActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();

    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        mRecyclerView = findViewById(R.id.recycleView);

        String[] names = new String[64];
        for(int i=0;i<names.length;i++){
            names[i] = getName(8);
        }

        mListAdapter = new ListAdapter(names);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((TextView)view).getText().toString();
                Log.w(TAG,"Clicked:" + text);
                showDialog(text);
            }
        });
    }

    private String getName(int length){
        StringBuilder builder = new StringBuilder();
        builder.append(("" + getChar()).toUpperCase());
        for(int i=0;i<length-1;i++){
            builder.append(("" + getChar()).toLowerCase());
        }
        return builder.toString();
    }

    private char getChar(){
        return (char)((int)'a' + (int)(27 * Math.random()));
    }

    private void showDialog(String text){
        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this).setMessage(R.string.app_name).setTitle(text);
        dialog.create().show();
    }
}