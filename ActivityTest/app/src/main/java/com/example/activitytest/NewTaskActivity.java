package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    static final String TAG = NewTaskActivity.class.getSimpleName();

    EditText et_task_name;
    EditText et_task_category;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Log.d(TAG, "onCreate: New activity created");

        et_task_name = findViewById(R.id.et_task);
        et_task_category = findViewById(R.id.editText);
        btn_save = findViewById(R.id.button);
        //todo get data from Intent
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_task_name.getText().toString().isEmpty()){
                    et_task_name.setText("NO EMPTY VALUES");
                }
                else{
                    Intent passData = new Intent();
                    passData.putExtra("Task",
                            et_task_name.getText().toString());
                    Log.d(TAG, "onClick: "+passData
                            .getStringExtra("Task"));

                    setResult(RESULT_OK, passData);
                    finish();
                }

            }
        });
    }
}
