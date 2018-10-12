package com.example.vadimgarkusha.vadymharkusha_comp304_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvTasks = findViewById(R.id.lvTasks);

        String[] tasks = {getString(R.string.task1), getString(R.string.task2), getString(R.string.task3)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, tasks);
        lvTasks.setAdapter(adapter);

        lvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch ((int)id){
                    case 0:
                         intent = new Intent(getApplicationContext(), Task1Activity.class);
                         break;

                }
                startActivity(intent);

            }
        });
    }
}
