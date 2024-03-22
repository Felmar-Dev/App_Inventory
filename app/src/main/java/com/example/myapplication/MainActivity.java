package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.AbstractCursor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    Inventory inventory = new Inventory();
    Login login = new Login();






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inventory.addItem("Banana", "Healthy Fruit", 5, 10.00);
        Button loginButton = findViewById(R.id.button_login);
        EditText username = findViewById(R.id.edit_text_username);
        EditText password = findViewById(R.id.edit_text_password);
        Button registerButton = findViewById(R.id.button_register);
        TextView errorText = findViewById(R.id.invalid_user_pass);

        errorText.setVisibility(View.INVISIBLE);
        Intent i = new Intent(this, register_page.class);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(i);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               try {
                   boolean test = Login.validateUser(username.getText().toString(), password.getText().toString());
                   Log.e("Success", "" + test);

               } catch (FileNotFoundException e) {

                   Log.e("Error","Error");
                   errorText.setVisibility(View.VISIBLE);
               }

           }
        });

    }



}