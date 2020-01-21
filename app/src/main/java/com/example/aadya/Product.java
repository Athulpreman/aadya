package com.example.aadya;

public class Product
{
    String productname,productrating,productprice;

    public Product() {
    }

    public Product(String productname, String productrating, String productprice) {
        this.productname = productname;
        this.productrating = productrating;
        this.productprice = productprice;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductrating() {
        return productrating;
    }

    public void setProductrating(String productrating) {
        this.productrating = productrating;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
