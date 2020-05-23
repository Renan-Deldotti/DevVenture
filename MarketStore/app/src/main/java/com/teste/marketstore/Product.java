package com.teste.marketstore;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private boolean isChecked = false;
    private float price;
    private String productName;
    private String description;
    private String shortDescription;

    public Product(int id, float price, String productName, String description, String shortDescription) {
        this.id = id;
        this.price = price;
        this.productName = productName;
        this.description = description;
        this.shortDescription = shortDescription;
    }

    public int getId() {
        return id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public float getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
