package com.example.zahran.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayList<product> arrayList;
    productadapter adapter;
    ListView listView;
    //ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = (ListView) findViewById(R.id.lv_post);
      //  View view3=getLayoutInflater().inflate(R.layout.item_product_list,null);
       // imageView =view3.findViewById(R.id.delete);
        arrayList = new ArrayList<product>();

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

        adapter = new productadapter(this, arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(Home.this);
        /*imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setOnItemClickListener(Home.this);
            }
        });*/

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        product item=arrayList.get(position);
        arrayList.remove(item);
        adapter=new productadapter(this,arrayList);
        listView.setAdapter(adapter);
    }
}
