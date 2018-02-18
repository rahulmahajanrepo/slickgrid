package com.raltd.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by rahulmahajan on 18/02/2018.
 */
@Component
public class ProductsPage {
    int pageNumber;
    List<Product> products;
    int total;

    public ProductsPage() {
    }

    public ProductsPage(int pageNumber, List<Product> products, int total) {
        this.pageNumber = pageNumber;
        this.products = products;
        this.total = total;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
