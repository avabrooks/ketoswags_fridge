package com.example.sping_portfolio.controllers;

import lombok.Getter;

@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class ItemBase {
    public int price;
    public String name, description;
    boolean essential;

    // basic constructor
    public ItemBase(String name, String description, int price, boolean essential) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.essential = essential;
    }

    // Sales pitch
    public String salesPitch() {
        int collegeCost = 40000;
        String salesMessage;
        int pitchNumber = collegeCost/price;
        salesMessage = "You can get " + name + " for the low price of " + price + ". It does this: " + description +
                        ". You could buy " + pitchNumber + " of these with one year of college tuition";
        return salesMessage;
    }

    // does the taxes on non-essential items
    public float getTax() {
        float n;

        if (essential) n = 0;
        else n = (float) (price * 0.2);

        return (n + price);
    }


}
