package com.example.arun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Object Declaration
    Button b;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializations - To link java codes with xml Components
        b = findViewById(R.id.loginButton);
        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);

        startActivity(new Intent(MainActivity.this,BottomNavigation.class));
        //onClickListener
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arun();
//                teja("you received a mail");
                addition(10,15,5);


            }
        });
    }


    //This is called Method
    private void arun()
    {


        String sEmail = email.getText().toString();
        String sPassword = password.getText().toString();

        if(sEmail.equals("123") || sPassword.equals("456"))
        {
            Toast.makeText(this, "login succesful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this,SecondActivity.class);
            i.putExtra("value","24");
            startActivity(i);
//            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }
        else
        {
            Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();

        }
    }
    private void teja(String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    private void addition(int a, int b, int c)
    {
        int d = a+b;
        int e = d-c;
        Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
    }

}