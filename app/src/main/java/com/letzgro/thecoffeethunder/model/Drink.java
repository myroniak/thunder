package com.letzgro.thecoffeethunder.model;

import java.util.ArrayList;

public class Drink {

    private String id;
    private String name;
    private String size;
    private int price;
    private ArrayList<Size> sizeList;

    public Drink(String id, String name, ArrayList<Size> sizeList) {
        this.id = id;
        this.name = name;
        this.sizeList = sizeList;
    }

    public Drink(String id, String name,String size, int price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Size> getSizeList() {
        return sizeList;
    }

    public void setSizeList(ArrayList<Size> sizeList) {
        this.sizeList = sizeList;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
