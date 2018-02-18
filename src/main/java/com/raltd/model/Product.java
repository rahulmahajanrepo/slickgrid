package com.raltd.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by rahulmahajan on 18/02/2018.
 */
@Component
public class Product {
    int id;
    String name;
    String category;
    Date dateFirstCame;
    String description;
    float price;

    public Product() {
    }

    public Product(int id, String name, String category, Date dateFirstCame, String description, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.dateFirstCame = dateFirstCame;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDateFirstCame() {
        return dateFirstCame;
    }

    public void setDateFirstCame(Date dateFirstCame) {
        this.dateFirstCame = dateFirstCame;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
