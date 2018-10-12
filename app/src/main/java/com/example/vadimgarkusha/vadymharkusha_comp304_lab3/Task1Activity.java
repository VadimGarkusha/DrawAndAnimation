package com.example.vadimgarkusha.vadymharkusha_comp304_lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Task1Activity extends AppCompatActivity {


    ImageView reusableImageView;

    int startx = 10;
    int starty = 10;
    int endx = 10;
    int endy = 10;
    int color = Color.GREEN;
    //
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        //SETTING UP ENV FOR DRAWING
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);

        //creating a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);

        reusableImageView = findViewById(R.id.ImageViewForDrawing);
        //setting a bitmap as content view for the image
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);

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
                        color = Color.WHITE;
                        break;
                    case (1):
                        color = Color.RED;
                        break;
                    case (2):
                        color = Color.YELLOW;
                        break;
                    case (3):
                        color = Color.BLUE;
                        break;
                    case (4):
                        color = Color.GREEN;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //paint.setColor(Color.WHITE);
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

    public void clearCanvas(View v)
    {
        paint.setColor(Color.BLACK);
    }

    public void moveRect(Canvas canvas)
    {
        canvas.translate(endx-startx, endy-starty);
        reusableImageView.setTranslationX(endx - startx);
        reusableImageView.setTranslationY(endy - starty);
        reusableImageView.setColorFilter(color);

    }

    public void drawLine(Canvas canvas)
    {
        canvas.drawLine(100,100,1000,1000,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }

    public void moveDown(View view){
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy+1;
        drawLine(canvas);
        moveRect(canvas);
        reusableImageView.invalidate();
    }

    public void moveTop(View view){
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy-1;
        drawLine(canvas);
        moveRect(canvas);
        reusableImageView.invalidate();
    }

    public void moveRight(View view){
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx+1;
        drawLine(canvas);
        moveRect(canvas);
        reusableImageView.invalidate();
    }

    public void moveLeft(View view){
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx-1;
        drawLine(canvas);
        moveRect(canvas);
        reusableImageView.invalidate();
    }


}
