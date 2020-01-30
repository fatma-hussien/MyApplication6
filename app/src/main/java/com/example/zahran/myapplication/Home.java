package com.example.zahran.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ArrayList<product> arrayList = new ArrayList<product>();

        arrayList.add(new product(R.drawable.nophoto,R.drawable.deleteicon,R.drawable.images3,R.drawable.hart,
                R.drawable.comment,R.drawable.stare,R.drawable.share,"Hussien Ahmed"));

        arrayList.add(new product(R.drawable.img,R.drawable.deleteicon,R.drawable.image4s,R.drawable.hart,
                R.drawable.comment,R.drawable.stare,R.drawable.share,"fatma hussien"));

        arrayList.add(new product(R.drawable.imag1jpg,R.drawable.deleteicon,R.drawable.images2,R.drawable.hart,
                R.drawable.comment,R.drawable.stare,R.drawable.share,"shaimaa hussien"));

        arrayList.add(new product(R.drawable.nophoto,R.drawable.deleteicon,R.drawable.images3,R.drawable.hart,
                R.drawable.comment,R.drawable.stare,R.drawable.share,"mohamed Ahmed"));


        arrayList.add(new product(R.drawable.img,R.drawable.deleteicon,R.drawable.welcom,R.drawable.hart,
                R.drawable.comment,R.drawable.stare,R.drawable.share,"fatma hussien"));

        productadapter adapter = new productadapter(this, arrayList);
        ListView listView = (ListView) findViewById(R.id.lv_post);
        listView.setAdapter(adapter);
    }
}
