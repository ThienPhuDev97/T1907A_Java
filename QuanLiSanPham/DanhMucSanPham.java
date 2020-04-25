/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiSanPham;

import java.util.Scanner;

/**
 *
 * @author Thien Phu
 */
public class DanhMucSanPham {

    int rollNo;
    String idDM;
    String nameDm;

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(int rollNo, String idDM, String nameDm) {
        this.rollNo = rollNo;
        this.idDM = idDM;
        this.nameDm = nameDm;
    }

    public DanhMucSanPham(String idDM, String nameDm) {
        this.idDM = idDM;
        this.nameDm = nameDm;
    }
    
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getIdDM() {
        return idDM;
    }

    public void setIdDM(String idDM) {
        this.idDM = idDM;
    }

    public String getNameDm() {
        return nameDm;
    }

    public void setNameDm(String nameDm) {
        this.nameDm = nameDm;
    }

    @Override
    public String toString() {
        return "DanhMucSanPham{" + "rollNo=" + rollNo + ", idDM=" + idDM + ", nameDm=" + nameDm + '}';
    }

    void display() {
        System.out.println(toString());
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap rollNo danh muc");
        rollNo = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap id danh muc ");
        idDM = sc.nextLine();
        System.out.println("Nhap ten danh muc");
        nameDm = sc.nextLine();
    }
}
