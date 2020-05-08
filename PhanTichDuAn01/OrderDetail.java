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
public class OrderDetail {

    String idOrder, idProduct;
    int quantity, price, totalMoney;

    public OrderDetail() {
    }

    public OrderDetail(String idOrder, String idProduct, int quantity, int price, int totalMoney) {

        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
        this.totalMoney = totalMoney;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
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

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "idOrder=" + idOrder + ", idProduct=" + idProduct + ", quantity=" + quantity + ", price=" + price + ", totalMoney=" + totalMoney + '}';
    }

    public void display() {
        System.out.println(toString());
    }
}
