package com.example.nsakthi.mysalestax;

import android.os.Parcelable;

public class AddItem
{
    String name;
    int quantity;
    double price;
    String flag;


    public AddItem(String name, int quantity, double price, String flag) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.flag = flag;
    }
}

