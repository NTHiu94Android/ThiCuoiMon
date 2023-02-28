package com.example.thicuoimon.Model;

public class XeMay {
    private int maXe;
    private String tenXe;
    private float gia;
    private String hangXe;

    public XeMay(int maXe, String tenXe, float gia, String hangXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.gia = gia;
        this.hangXe = hangXe;
    }

    public XeMay(String tenXe, float gia, String hangXe) {
        this.tenXe = tenXe;
        this.gia = gia;
        this.hangXe = hangXe;
    }

    public XeMay() {
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }
}
