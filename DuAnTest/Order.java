/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAnTest;

/**
 *
 * @author Thien Phu
 */
public class Order {

    String idOrder, idCustomer, idUser, dateOrder;

    public Order() {
    }

    public Order(String idOrder, String idCustomer, String idUser, String dateOrder) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.idUser = idUser;
        this.dateOrder = dateOrder;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", idCustomer=" + idCustomer + ", idUser=" + idUser + ", dateOrder=" + dateOrder + '}';
    }

    public void display() {
        System.out.println(toString());
    }
}
