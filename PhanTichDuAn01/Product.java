/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhanTichDuAn01;

/**
 *
 * @author Thien Phu
 */
public class Product {

    String idProduct, idCategory, nameProduct;
    int quantity, price;
    String dateManufacture, expiryDate;

    public Product() {
    }

    public Product(String idProduct, String idCategory, String nameProduct, int quantity, int price, String dateManufacture, String expiryDate) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.dateManufacture = dateManufacture;
        this.expiryDate = expiryDate;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(String dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", idCategory=" + idCategory + ", nameProduct=" + nameProduct + ", quantity=" + quantity + ", price=" + price + ", dateManufacture=" + dateManufacture + ", expiryDate=" + expiryDate + '}';
    }

    public void display() {
        System.out.println(toString());
    }
}
