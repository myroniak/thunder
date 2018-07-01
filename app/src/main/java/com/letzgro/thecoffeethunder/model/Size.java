package com.letzgro.thecoffeethunder.model;

public class Size {

    private long id;
    private boolean isEnable;
    private String price;

    public Size(long id, boolean isEnable, String price) {
        this.id = id;
        this.isEnable = isEnable;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
