package com.sample.arch.forbidden;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.buttonDialogTitled).setOnClickListener((view) -> showTitledDialog());

    }

    void showTitledDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Dialog title");
        builder.setMessage("Dialog message");
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setPositiveButton("OK Button", (dialog, which) -> Toast.makeText(DialogActivity.this,"Positive",Toast.LENGTH_SHORT).show());
        builder.setNegativeButton("Cancel Button", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this,"Negative",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

}