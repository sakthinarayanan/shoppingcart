package com.example.nsakthi.mysalestax;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends Activity  {
    TextView textView;
    ArrayList<AddItem> shoppingitems = ShoppingCart.item;
    MyRecyclerViewAdapter adapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.invoice_activity);
        setTitle("Invoice Details");

     //     Bundle bundle = getIntent().getExtras();
     //   itemsec = bundle.getParcelable("itemarray");
     //   textView = (TextView)findViewById(R.id.mytext);
        //  textView.setText(itemsec.get(0).name);

      //  Log.d("sak", itemsec.get(0).name);
        Log.d("act2", ShoppingCart.item.get(0).name+"");
        Log.d("act2", ShoppingCart.item.get(0).quantity+"");
        Log.d("act2", ShoppingCart.item.get(0).price+"");
        Log.d("act2", ShoppingCart.item.get(0).flag+"");

        Log.d("act2", ShoppingCart.item.size() +"");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, shoppingitems);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    }
