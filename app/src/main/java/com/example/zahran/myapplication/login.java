package com.example.zahran.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    TextInputLayout textInputEmail,textInputusername,textInputpassword;
    TextInputEditText textInputEmail_et,textInputusername_et,textInputpassword_et;
    Button button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textInputEmail=findViewById(R.id.email);
        textInputusername=findViewById(R.id.username);
        textInputpassword=findViewById(R.id.pass);
        textInputEmail_et=findViewById(R.id.et_email);
        textInputpassword_et=findViewById(R.id.et_pass);
        textInputusername_et=findViewById(R.id.et_username);
        button_login=findViewById(R.id.login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validatemail()|!validateuser()|!validatepass())
                {
                    return;
                }
                else
                {
                    textInputEmail_et.setText("");
                    textInputusername_et.setText("");
                    textInputpassword_et.setText("");
                    Intent i=new Intent(login.this,Home.class);
                    startActivity(i);
                }
            }
        });

    }
    private boolean validatemail()
    {

        String emailstr=textInputEmail.getEditText().getText().toString().trim();

        if(emailstr.isEmpty())
        {
            textInputEmail.setError("fail can't be empty  ");
            return  false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailstr).matches())
        {
            textInputEmail.setError("please enter a valid email address ");
            return  false;
        }
       else
        {
            textInputEmail.setError(null);
            return true;
        }
    }
    private boolean validateuser()
    {
        String userstr=textInputusername.getEditText().getText().toString().trim();

        if((userstr.isEmpty()))
        {
            textInputusername.setError("fail can't be empty  ");
            return  false;
        }
        else if((userstr.length())>15)
        {
            textInputusername.setError("username too long");
            return false;
        }
        else
        {
            textInputusername.setError(null);
            return true;
        }
    }
    private boolean validatepass()
    {
        String passstr=textInputpassword.getEditText().getText().toString().trim();

        if((passstr.isEmpty()))
        {
            textInputpassword.setError("fail can't be empty  ");
            return  false;
        }
        else
        {
            textInputpassword.setError(null);
            return true;
        }
    }
}
