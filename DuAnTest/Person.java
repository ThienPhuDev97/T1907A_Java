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
public class Person {
    String ID_person, fullName,birthday, gender,address,phone;
    int identity_card;

    public Person() {
    }

    public Person(String ID_person, String fullName, String birthday, String gender, String address, String phone, int identity_card) {
        this.ID_person = ID_person;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.identity_card = identity_card;
    }

    public String getID_person() {
        return ID_person;
    }

    public void setID_person(String ID_person) {
        this.ID_person = ID_person;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public int getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(int identity_card) {
        this.identity_card = identity_card;
    }

    @Override
    public String toString() {
        return "Person{" + "ID_person=" + ID_person + ", fullName=" + fullName + ", birthday=" + birthday + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", identity_card=" + identity_card + '}';
    }

    
    
    
}
