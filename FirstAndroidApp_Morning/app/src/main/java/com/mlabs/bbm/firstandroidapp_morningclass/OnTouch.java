package com.mlabs.bbm.firstandroidapp_morningclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.MotionEvent;

import android.view.View;

import android.widget.EditText;

import android.widget.ImageView;


public class OnTouch extends AppCompatActivity
{
    EditText x1,x2,y1,y2, DifferentX, differentY,dir, locquad;


    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch);


        final ImageView imgView = (ImageView)findViewById(R.id.zGjMqiX);

        x1=(EditText)findViewById(R.id.x1);

        x2=(EditText)findViewById(R.id.x2);

        y1=(EditText)findViewById(R.id.y1);

        y2=(EditText)findViewById(R.id.y2);

        DifferentX =(EditText)findViewById(R.id.dx);

        differentY =(EditText)findViewById(R.id.dy);

        dir=(EditText)findViewById(R.id.dir);

        locquad =(EditText)findViewById(R.id.quad);


        imgView.setOnTouchListener(new View.OnTouchListener()
        {
            float initX = 0, initY = 0, finalX = 0, finalY = 0;


            @Override

            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        initX = motionEvent.getX();
                        initY = motionEvent.getY();
                        return true;

                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();

                        display(initX, finalX, initY, finalY);
                        return false;
                }return false;
            }
        });
    }


    public void display(float inix, float finx, float iniy, float finy){
        String x = "", y = "";
        float delx, dely;

        delx = inix-finx;
        dely = iniy-finy;

        if(inix == finy){
        }else if(inix > finx){
            x = "Left";
        }else if(inix < finx){
            x = "Right";
        }

        if(iniy == finy){

        }else if(iniy > finy){
            y = "Up";
        }else if (iniy < finy){
            y = "Down";
        }

        x1.setText("x1: "+Float.toString(inix));
        x2.setText("x2: "+Float.toString(finx));
        y1.setText("y1: "+Float.toString(iniy));
        y2.setText("y2: "+Float.toString(finx));
        DifferentX.setText("DifferentX: "+Float.toString(delx));
        differentY.setText("differentY: "+Float.toString(dely));

        if(x.equals("Right")){
            if(y.equals("Up")){
                dir.setText("Swipe: Right-Up");
                locquad.setText("Quadrant: 1");
            }else{
                dir.setText("Swipe: Right-Down");
                locquad.setText("Quadrant: 4");
            }
        }else if(x.equals("Left")){
            if(y.equals("Up")){
                dir.setText("Swipe: Left-Up");
                locquad.setText("Quadrant: 2");
            }else{
                dir.setText("Swipe: Left-Down");
                locquad.setText("Quadrant: 3");
            }
        }else{
            dir.setText("Swipe: Origin");
            locquad.setText("Quadrant: 0");
        }
    }
}


