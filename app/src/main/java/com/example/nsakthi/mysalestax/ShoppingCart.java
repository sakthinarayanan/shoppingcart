package com.example.nsakthi.mysalestax;

import java.util.ArrayList;

public class ShoppingCart {
    AddItem addItem;
    public static ArrayList<AddItem> item = new ArrayList<AddItem>();

    public static void put(AddItem addItem)
    {

        item.add(addItem);
    }

}
