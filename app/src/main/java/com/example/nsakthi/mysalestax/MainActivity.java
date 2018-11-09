package com.example.nsakthi.mysalestax;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends Activity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    public ArrayList<AddItem> item = new ArrayList<AddItem>();
    private Spinner spinner1, spinner2, spinner3, spinner4;
    private Button btnSubmit,btnSubmit2;
    private EditText editText, name, quantity, price;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // addItemsOnSpinner2();
        addListenerOnButton();
        additem();
        secondclass();
        //addListenerOnSpinnerItemSelection();
    }

    // add items into spinner dynamically
//    public void addItemsOnSpinner2() {
//
//        spinner2 = (Spinner) findViewById(R.id.category);
//        List<String> list = new ArrayList<String>();
//        list.add("list 1");
//        list.add("list 2");
//        list.add("list 3");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter);
//    }

//    public void addListenerOnSpinnerItemSelection() {
//        spinner1 = (Spinner) findViewById(R.id.category);
//        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//
//    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.category);
        //spinner2 = (Spinner) findViewById(R.id.quantity);
        btnSubmit = (Button) findViewById(R.id.CheckPrice);

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                editText = (EditText)findViewById(R.id.Price);
                String cat = String.valueOf(spinner1.getSelectedItem());
                if(cat.equals("Books"))
                    editText.setText("100", TextView.BufferType.EDITABLE);
                else  if(cat.equals("Cosmetics"))
                    editText.setText("200", TextView.BufferType.EDITABLE);
                else  if(cat.equals("Movies"))
                    editText.setText("50", TextView.BufferType.EDITABLE);
                else  if(cat.equals("Food"))
                    editText.setText("70", TextView.BufferType.EDITABLE);
                else  if(cat.equals("Medical"))
                    editText.setText("1000", TextView.BufferType.EDITABLE);
                else  if(cat.equals("Chocolates"))
                    editText.setText("300", TextView.BufferType.EDITABLE);


//
//
//                Toast.makeText(MainActivity.this,
//                        "OnClickListener : " +
//                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) ,
//                        Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void additem() {

        btnSubmit = (Button) findViewById(R.id.Add);
        name   = (EditText)findViewById(R.id.Item);
        price   = (EditText)findViewById(R.id.Price);
        radioGroup = (RadioGroup) findViewById(R.id.radio);

        spinner4 = (Spinner) findViewById(R.id.category);
        spinner3 = (Spinner) findViewById(R.id.quantity);



        btnSubmit.setOnClickListener(new OnClickListener() {
        int count = 0;
            @Override
            public void onClick(View v) {
                String quantity = String.valueOf(spinner3.getSelectedItem());
                String category = String.valueOf(spinner4.getSelectedItem());
                double tax;
                double myprice = Double.parseDouble(price.getText().toString());
                if(category.equals("Books")||category.equals("Food")|| category.equals("Medical"))
                    tax = 0;
                else
                    tax = myprice* 10/100;


                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                Log.d("Logging", radioButton.getText().toString());


                if(radioButton.getText().toString().equals("Imported")) {
                    Log.d("sak", "i'm here");
                    tax = tax + (myprice * 5 / 100);
                }

                myprice = myprice + tax;
                AddItem itemval = new AddItem( name.getText().toString(), Integer.parseInt( quantity.toString()), myprice,  radioButton.getText().toString());
                item.add(itemval);
                ShoppingCart.put(itemval);
                Log.d("sak", item.get(0).name+"");
                Log.d("sak", item.get(0).quantity+"");
                Log.d("sak", item.get(0).price+"");
                Log.d("sak", item.get(0).flag+"");

                Log.d("sak", item.size() +"");


//
//
//                Toast.makeText(MainActivity.this,
//                        "OnClickListener : " +
//                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) ,
//                        Toast.LENGTH_SHORT).show();
            }

        });


    }
    public void secondclass(){
        btnSubmit2 = (Button) findViewById(R.id.ViewBill);
        btnSubmit2.setOnClickListener(new OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

               // intent.putExtra("itemarray", item);
                startActivity(intent);


            }

        });


    }

    }


