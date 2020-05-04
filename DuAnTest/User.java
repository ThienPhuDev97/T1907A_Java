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
public class User {
    String ID_user,userName,passWord,ID_person, Role;

    public User() {
    }

    public User(String ID_user, String userName, String passWord, String ID_person, String Role) {
        this.ID_user = ID_user;
        this.userName = userName;
        this.passWord = passWord;
        this.ID_person = ID_person;
        this.Role = Role;
    }

    public String getID_user() {
        return ID_user;
    }

    public void setID_user(String ID_user) {
        this.ID_user = ID_user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getID_person() {
        return ID_person;
    }

    public void setID_person(String ID_person) {
        this.ID_person = ID_person;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "User{" + "ID_user=" + ID_user + ", userName=" + userName + ", passWord=" + passWord + ", ID_person=" + ID_person + ", Role=" + Role + '}';
    }
    
    
}
