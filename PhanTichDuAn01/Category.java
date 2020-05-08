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
public class Category {

    String iD_category, nameCategory, idUser;

    public Category() {
    }

    public Category(String iD_category, String nameCategory, String idUser) {
        this.iD_category = iD_category;
        this.nameCategory = nameCategory;
        this.idUser = idUser;
    }

    public String getiD_category() {
        return iD_category;
    }

    public void setiD_category(String iD_category) {
        this.iD_category = iD_category;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Category{" + "iD_category=" + iD_category + ", nameCategory=" + nameCategory + ", idUser=" + idUser + '}';
    }

    public void display() {
        System.out.println(toString());
    }

}
