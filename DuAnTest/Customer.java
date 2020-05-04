/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigc;

/**
 *
 * @author Administrator
 */
public class Customer {
    String ID_customer,name_customer,gender,address,phone,ID_user;
    int identity_card;

    public Customer() {
    }

    public Customer(String ID_customer, String name_customer, String gender, String address, String phone, String ID_user, int identity_card) {
        this.ID_customer = ID_customer;
        this.name_customer = name_customer;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.ID_user = ID_user;
        this.identity_card = identity_card;
    }

    public String getID_customer() {
        return ID_customer;
    }

    public void setID_customer(String ID_customer) {
        this.ID_customer = ID_customer;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getID_user() {
        return ID_user;
    }

    public void setID_user(String ID_user) {
        this.ID_user = ID_user;
    }

    public int getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(int identity_card) {
        this.identity_card = identity_card;
    }

    @Override
    public String toString() {
        return "Customer{" + "ID_customer=" + ID_customer + ", name_customer=" + name_customer + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", ID_user=" + ID_user + ", identity_card=" + identity_card + '}';
    }
    
    
}
