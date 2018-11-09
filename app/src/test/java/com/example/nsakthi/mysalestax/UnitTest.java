package com.example.nsakthi.mysalestax;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {
    @Test
    public void cartadd() {
        ArrayList<AddItem> shoppingitems = ShoppingCart.item;
        AddItem itemval = new AddItem( "Harry Potter", 4, 100,  "Imported");
        //shoppingitems.add(itemval);
        ShoppingCart.put(itemval);

        assertEquals(ShoppingCart.item.size(), 1);

    }
    @Test
    public void arrayadd() {
        ArrayList<AddItem> shoppingitems = new ArrayList<AddItem>();
        AddItem itemval = new AddItem( "Harry Potter", 4, 100,  "Imported");
        shoppingitems.add(itemval);
        //ShoppingCart.put(itemval);

        assertEquals(shoppingitems.size(), 1);

    }

    @Test
    public void cartitem() {
        //assertEquals(ShoppingCart.item.size(), 0);
        ArrayList<AddItem> shoppingitems = new ArrayList<AddItem>();
        AddItem itemval = new AddItem( "Harry Potter", 4, 100,  "Imported");
        shoppingitems.add(itemval);
         //ShoppingCart.put(itemval);

        //assertEquals(shoppingitems.size(), 1);
        assertEquals(shoppingitems.get(0).name, "Harry Potter");
        assertEquals(shoppingitems.get(0).quantity, 4.0,0);
        assertEquals(shoppingitems.get(0).price, 100.0,0);
        assertEquals(shoppingitems.get(0).flag, "Imported");



    }
}