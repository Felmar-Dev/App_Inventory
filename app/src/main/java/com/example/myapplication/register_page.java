package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;

public class register_page extends AppCompatActivity {
    Button backbutton;
    Login login = new Login();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        TextView errorText = findViewById(R.id.textView8);
        errorText.setVisibility(View.INVISIBLE);
        Button registerButton = findViewById(R.id.button);
        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);


        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Login.createUser(username.getText().toString(), password.getText().toString());
                }
                catch (IOException e){
                    Log.e("Error", "Error");
                }
            }
        });
    }
}
