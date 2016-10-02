package com.example.user.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    double height;
    double shoeSize;
    double waist;
    double chest;
    double shoulder;
    String color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button done = (Button) findViewById(R.id.buttonDone);
        Button skip = (Button) findViewById(R.id.buttonSkip);
        final EditText editHeight = (EditText) findViewById(R.id.editHeight);
        final EditText editShoe = (EditText) findViewById(R.id.editShoe);
        final EditText editWaist = (EditText) findViewById(R.id.editWaist);
        final EditText editChest = (EditText) findViewById(R.id.editChest);
        final EditText editShoulder = (EditText) findViewById(R.id.editShoulder);
        final EditText editColor = (EditText) findViewById(R.id.editColor);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    height = Double.parseDouble(editHeight.getText().toString());
                    shoeSize = Double.parseDouble(editShoe.getText().toString());
                    waist = Double.parseDouble(editWaist.getText().toString());
                    chest = Double.parseDouble(editChest.getText().toString());
                    shoulder = Double.parseDouble(editShoulder.getText().toString());
                    color = editColor.getText().toString();
                    System.out.println("height "+height);
                    System.out.println("shoe size "+shoeSize);
                    System.out.println("waist "+waist);
                    System.out.println("chest "+chest);
                    System.out.println("shoulder "+shoulder);
                    System.out.println("color "+color);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                    builder.setMessage("Thank you for your response! We will use this information to improve your experience as well as your friends'.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                    Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                                    startActivity(myIntent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                catch(NumberFormatException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                    builder.setMessage("Please enter valid information.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
