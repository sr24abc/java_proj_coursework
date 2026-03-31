package com.mycompany.team_proj_java;

import java.util.ArrayList;

public class Collection {

    private ArrayList<Item> items;

    public Collection() {
        items = new ArrayList<>();
    }

    //  add item to collection
    public void addItem(Item item) {
        items.add(item);
    }

    //  search items by title
    public ArrayList<Item> searchItems(String searchTerm) {
        ArrayList<Item> results = new ArrayList<>();

        for (Item item : items) {
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(item);
            }
        }

        return results;
    }

    // remove item
    public void removeItem(Item item) {
        items.remove(item);
    }
}