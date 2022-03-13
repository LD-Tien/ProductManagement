/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */
public class Product extends Category{
    String productId;
    String brand;
    String productName;
    String color;
    String size;
    int quantityAvailable;
    long unitPrice;

    public Product(String productId, String brand, String productName, String color, String size, int quatityAvaiable, long untilPrice, String CategoryId, String CategoryName) {
        super(CategoryId, CategoryName);
        this.productId = productId;
        this.brand = brand;
        this.productName = productName;
        this.color = color;
        this.size = size;
        this.quantityAvailable = quatityAvaiable;
        this.unitPrice = untilPrice;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductName() {
        return productName;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setCategoryId(String CategoryId) {
        this.CategoryId = CategoryId;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
}
