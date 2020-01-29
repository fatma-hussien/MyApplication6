package com.example.zahran.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button button_signup;
    TextInputLayout textInputEmail,textInputpassword;
    TextInputEditText textInputEmail_et,textInputpassword_et;
    Button button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textInputEmail=findViewById(R.id.email);
        textInputpassword=findViewById(R.id.pass);
        textInputEmail_et=findViewById(R.id.et_email);
        textInputpassword_et=findViewById(R.id.et_pass);
        button_login=findViewById(R.id.login);
        button_signup=findViewById(R.id.signup);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strEmail=textInputEmail_et.getText().toString().trim();
                String strpass=textInputpassword_et.getText().toString().trim();
                if(!validatemail()|!validatepass())
                {
                    return;
                }
                else {
                    if (strEmail.equals("fatma@gmail.com") && strpass.equals("123"))
                    {
                        textInputEmail_et.setText("");
                        textInputpassword_et.setText("");
                        Intent i = new Intent(login.this, Home.class);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(login.this,"Email or password is not correct ",Toast.LENGTH_LONG).show();
                }
            }
        });
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(login.this, signup.class);
                startActivity(i);
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
