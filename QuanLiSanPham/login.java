/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiSanPham;

/**
 *
 * @author Thien Phu
 */
public class login {

    int rollNo;
    String username, pass;

    public login() {
    }

    public login(int rollNo, String username, String pass) {
        this.rollNo = rollNo;
        this.username = username;
        this.pass = pass;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "login{" + "rollNo=" + rollNo + ", username=" + username + ", pass=" + pass + '}';
    }

    void display() {
        System.out.println(toString());
    }
}
