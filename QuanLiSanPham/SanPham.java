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
public class SanPham {

    String idSp, maDanhMuc;
    String nameSp, price;
    String inputdate, outputdate, hsd, mota;

    public SanPham() {
    }

    public SanPham(String idSp, String maDanhMuc, String nameSp, String price, String inputdate, String outputdate, String hsd, String mota) {
        this.idSp = idSp;
        this.maDanhMuc = maDanhMuc;
        this.nameSp = nameSp;
        this.price = price;
        this.inputdate = inputdate;
        this.outputdate = outputdate;
        this.hsd = hsd;
        this.mota = mota;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getNameSp() {
        return nameSp;
    }

    public void setNameSp(String nameSp) {
        this.nameSp = nameSp;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInputdate() {
        return inputdate;
    }

    public void setInputdate(String inputdate) {
        this.inputdate = inputdate;
    }

    public String getOutputdate() {
        return outputdate;
    }

    public void setOutputdate(String outputdate) {
        this.outputdate = outputdate;
    }

    public String getHsd() {
        return hsd;
    }

    public void setHsd(String hsd) {
        this.hsd = hsd;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSp=" + idSp + ", maDanhMuc=" + maDanhMuc + ", nameSp=" + nameSp + ", price=" + price + ", inputdate=" + inputdate + ", outputdate=" + outputdate + ", hsd=" + hsd + ", mota=" + mota + '}';
    }

    void display() {
        System.out.println(toString());
    }
}
