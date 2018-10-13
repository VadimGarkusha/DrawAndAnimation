package com.example.vadimgarkusha.vadymharkusha_comp304_lab3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Task1Activity extends AppCompatActivity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        customCanvas = findViewById(R.id.signature_canvas);

        //CHOOSE COLOR SPINNER
        Spinner spColors = findViewById(R.id.spColors);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.colorAr));
        spColors.setAdapter(adapter);
        spColors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch ((int) id) {
                    case (0):
                        customCanvas.setColor(Color.BLACK);
                        break;
                    case (1):
                        customCanvas.setColor(Color.RED);
                        break;
                    case (2):
                        customCanvas.setColor(Color.YELLOW);
                        break;
                    case (3):
                        customCanvas.setColor(Color.BLUE);
                        break;
                    case (4):
                        customCanvas.setColor(Color.GREEN);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                customCanvas.setColor(Color.BLACK);
            }

        });


        //CHOOSE THICKNESS SPINNER
        Spinner spThickness = findViewById(R.id.spThickness);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.thicknessAr));
        spThickness.setAdapter(adapter);
        /*spThickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch ((int) id) {
                    case (0):
                        paint.setStrokeWidth(5);
                        break;
                    case (1):
                        paint.setStrokeWidth(10);
                        break;
                    case (2):
                        paint.setStrokeWidth(15);
                        break;
                    case (3):
                        paint.setStrokeWidth(20);
                        break;
                    case (4):
                        paint.setStrokeWidth(25);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                paint.setStrokeWidth(5);
            }
        });*/

    }

    public void moveDown(View view){
        customCanvas.justMoveY(10);
    }

    public void moveTop(View view){
        customCanvas.justMoveY(-10);
    }

    public void moveRight(View view){
        customCanvas.justMoveX(10);
    }

    public void moveLeft(View view){
        customCanvas.justMoveX(-10);
    }

    public void clear(View view){
        customCanvas.clearCanvas();
    }


}
