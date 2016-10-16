package com.example.danielmsibi.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    private static Button bt ,bs;
    EditText name,pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
      //  OnClickButtonListener();
        name = (EditText)findViewById(R.id.editUname);
        pass =  (AutoCompleteTextView)findViewById(R.id.passText);
    }

    public  void OnClickButtonListener(View v) {

        String user = name.getText().toString();

        String word = pass.getText().toString();
        String type = "login";

        bt = (Button) findViewById(R.id.button);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tent = new Intent("com.example.danielmsibi.recipeapp.Content");
                startActivity(tent);
            }
        });

        Toast sh = Toast.makeText(LogInActivity.this, "Check details and make sure they correspond", Toast.LENGTH_LONG);
        sh.show();
    }
    public  void OnClickForSignUp(View v) {



        bs = (Button) findViewById(R.id.txtsign);


        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tent = new Intent("com.example.danielmsibi.recipeapp.SignUp");
                startActivity(tent);
            }
        });

        Toast sh = Toast.makeText(LogInActivity.this, "Welcome to the best recipes", Toast.LENGTH_LONG);
        sh.show();
    }
}
