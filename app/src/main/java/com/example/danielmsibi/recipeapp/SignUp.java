package com.example.danielmsibi.recipeapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    EditText fname,lname,uname,email,pass, cpass;
    Context context = this;
Button bt;
    Database database;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fname = (EditText)findViewById(R.id.editfname);
        lname = (EditText)findViewById(R.id.editlname);
        uname = (EditText)findViewById(R.id.edituname);
        email = (EditText)findViewById(R.id.editemail);
        pass = (EditText)findViewById(R.id.editpass);
        cpass = (EditText)findViewById(R.id.editcpass);
    }

    public void addAdmin(View view)
    {
        String  first = fname.getText().toString();
        String last = lname.getText().toString();
        String user = uname.getText().toString();
        String mail = email.getText().toString();
        String password = pass.getText().toString();
        String cpassword = cpass.getText().toString();

        database = new Database(context);
        sqLiteDatabase = database.getWritableDatabase();
        database.addInformation(first,last,user,mail,password,sqLiteDatabase);


        if(password.equals(cpassword))
        {
            Toast.makeText(getBaseContext(), "Data saved ", Toast.LENGTH_LONG).show();
             Intent tent = new Intent(SignUp.this,Content.class);
                    startActivity(tent);
                }
        else {
            Toast.makeText(getBaseContext(), "Incorrect details ", Toast.LENGTH_LONG).show();
        }
        database.close();
        }




    }

