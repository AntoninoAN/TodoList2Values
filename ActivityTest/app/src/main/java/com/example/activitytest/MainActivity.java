package com.example.activitytest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    List<String> dataSet = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;
    FloatingActionButton floatingActionButton;
    private int TASK_REQUEST_CODE = 2;//random.org

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_task);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.two_line_list_item);

        listView.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewTaskActivity();
            }
        });
    }

    public void openNewTaskActivity(){
        Intent intent = new Intent();
        intent.setClass(this,NewTaskActivity.class);
        startActivityForResult(intent, TASK_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: "+
                requestCode+" "+resultCode+" "+data.getDataString());
        if(TASK_REQUEST_CODE == requestCode){
            if(resultCode == RESULT_OK){
                if(data != null){//|| && != &
                    //todo get data and populate to Adapter
                    adapter.add(data.getDataString());
                }
            }
        }
        else {
            //todo this is not for us!
        }
    }
}
