/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;

import java.util.ArrayList;

public class Collection {

    // list of all items
    private ArrayList<Item> items;

    // constructor
    public Collection() {
        items = new ArrayList<>();
    }

    // add item to collection
    public void addItem(Item item) {
        if (item == null) {
            System.out.println("Item cannot be null");
            return;
        }

        items.add(item);
    }

    // remove item from collection
    public void removeItem(Item item) {
        if (item == null) {
            System.out.println("Item cannot be null");
            return;
        }

        if (!items.contains(item)) {
            System.out.println("Item not found");
            return;
        }

        items.remove(item);
    }

    // search items by title
    public ArrayList<Item> searchItems(String searchTerm) {
        ArrayList<Item> results = new ArrayList<>();

        if (searchTerm == null || searchTerm.isEmpty()) {
            System.out.println("Invalid search term");
            return results;
        }

        for (Item item : items) {
            if (item != null && item.getTitle() != null) {
                if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                    results.add(item);
                }
            }
        }

        return results;
    }

    // get one item by exact title
    public Item getItem(String title) {
        if (title == null || title.isEmpty()) {
            return null;
        }

        for (Item item : items) {
            if (item != null && item.getTitle() != null) {
                if (item.getTitle().equalsIgnoreCase(title)) {
                    return item;
                }
            }
        }

        return null;
    }

    // getter for all items
    public ArrayList<Item> getItems() {
        return items;
    }
}