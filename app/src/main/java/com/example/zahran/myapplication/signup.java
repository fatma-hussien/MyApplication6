package com.example.zahran.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class signup extends AppCompatActivity {

    EditText et_fname,et_lname;
    TextInputEditText et_email,et_password,et_repassword;
    MaskEditText et_phone;
    RadioButton b_gen1,b_gen2;
    AutoCompleteTextView autoCompleteTextView;
    private  static final  int pic_image=1;
    Uri imguri;
    CircleImageView circleImageView;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        circleImageView=findViewById(R.id.circleimagesignup);
        autoCompleteTextView=findViewById(R.id.auto);
        btn_signup=findViewById(R.id.btn_signup);
        et_fname=findViewById(R.id.fname);
        et_lname=findViewById(R.id.lname);
        et_email=findViewById(R.id.et_email_signup);
        et_password=findViewById(R.id.et_pass_signup);
        et_repassword=findViewById(R.id.et_repass_signup);
        et_phone=findViewById(R.id.number);
        b_gen1=findViewById(R.id.radiobutton1);
        b_gen2=findViewById(R.id.radiobutton2);




        String[] countries=getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        autoCompleteTextView.setAdapter(adapter);
        final String input=autoCompleteTextView.getText().toString();

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"select picture "),pic_image);
                btn_signup.setEnabled(true);
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean bool_gen1,bool_gen2;
                bool_gen1=b_gen1.isChecked();
                bool_gen2=b_gen2.isChecked();

                if( (et_fname.getText().toString().isEmpty())|(et_lname.getText().toString().isEmpty())
                        |(et_email.getText().toString().isEmpty())|(et_password.getText().toString().isEmpty())
                        |(et_repassword.getText().toString().isEmpty())|(et_phone.getText().toString().isEmpty())|!(bool_gen1| bool_gen2))
                {
                    if(!(bool_gen1| bool_gen2))
                    {
                        b_gen1.setError("Legender is requered");
                        b_gen1.requestFocus();
                        b_gen2.setError("Legender is requered");
                        b_gen2.requestFocus();
                    }
                    if((et_phone.getText().toString().isEmpty()))
                    {
                        et_phone.setError("phone is requered");
                        et_phone.requestFocus();
                    }
                    if(input.equals(""))
                    {
                        autoCompleteTextView.setError("country is requered");
                        autoCompleteTextView.requestFocus();
                    }
                    if(et_password.getText().toString().isEmpty())
                    {
                        et_password.setError("Password is requered");
                        et_password.requestFocus();
                    }
                    if(!(et_password.getText().toString().equals(et_repassword.getText().toString()))) {
                        et_repassword.setError("Passwords do not match");
                        et_repassword.requestFocus();
                    }
                    if((et_email.getText().toString().isEmpty()))
                    {
                        et_email.setError("E-mail is requered");
                        et_email.requestFocus();
                    }
                    if((et_lname.getText().toString().isEmpty()))
                    {
                        et_lname.setError("Last Name is requered");
                        et_lname.requestFocus();
                    }
                    if((et_fname.getText().toString().isEmpty()))
                    {
                        et_fname.setError("First Name is requered");
                        et_fname.requestFocus();
                    }

                }
                else
                {
                    Intent intent=new Intent(signup.this,mypage.class);
                    startActivity(intent);
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        try {

            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            circleImageView.setImageBitmap(bitmap);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
            if(requestCode==pic_image&&resultCode==RESULT_OK)
            {
                imguri=data.getData();
                Bitmap bitmap2= MediaStore.Images.Media.getBitmap(getContentResolver(),imguri);
                circleImageView.setImageBitmap(bitmap2);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
