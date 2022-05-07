package com.offcn.bean;

public class Product {
    private  int id;
    private  String productname;

    public Product(int id, String productname) {
        this.id = id;
        this.productname = productname;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}
