package com.example.danielmsibi.recipeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    private static Button bt ;

    Database helper = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
       // OnClickButtonListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public  void OnClickButtonListener()
    {
        EditText name = (EditText)findViewById(R.id.editUname);
        String user = name.getText().toString();
        EditText pass =  (AutoCompleteTextView)findViewById(R.id.passText);
        String word = pass.getText().toString();
        bt = (Button)findViewById(R.id.button);

       String password = helper.searchPas(user);

        if(word.equals(password))
        {


            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tent = new Intent("com.example.danielmsibi.recipeapp.Content");
                    startActivity(tent);
                }
            });
        }
        else
        {
            Toast sh = Toast.makeText(LogInActivity.this,"Check details and make sure they correspond", Toast.LENGTH_LONG);
            sh.show();
        }
    }
}
