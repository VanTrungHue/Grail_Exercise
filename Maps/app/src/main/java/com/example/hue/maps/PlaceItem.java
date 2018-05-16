package com.example.hue.maps;

import java.io.Serializable;

public class PlaceItem implements Serializable{
    private String Tieude;
    private String Link;
    private int Hinh;
    private double Kinhdo;
    private double Vido;

    public PlaceItem(String tieude, String link, int hinh, double kinhdo, double vido) {
        Tieude = tieude;
        Link = link;
        Hinh = hinh;
        Kinhdo = kinhdo;
        Vido = vido;
    }

    public String getTieude() {
        return Tieude;
    }

    public void setTieude(String tieude) {
        Tieude = tieude;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public double getKinhdo() {
        return Kinhdo;
    }

    public void setKinhdo(double kinhdo) {
        Kinhdo = kinhdo;
    }

    public double getVido() {
        return Vido;
    }

    public void setVido(double vido) {
        Vido = vido;
    }
}
