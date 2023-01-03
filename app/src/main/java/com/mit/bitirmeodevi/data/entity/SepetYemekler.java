package com.mit.bitirmeodevi.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SepetYemekler implements Serializable {
    @SerializedName("yemek_id")
    private int yemek_id;
    @SerializedName("yemek_ad")
    private String yemek_ad;
    @SerializedName("yemek_resim_ad")
    private String yemek_resim_ad;
    @SerializedName("yemek_fiyat")
    private int yemek_fiyat;
    @SerializedName("yemek_siparis_adet")
    private int yemek_siparis_adet;
    @SerializedName("kullanici_adi")
    private String kullanici_adi;

    public SepetYemekler() {
    }

    public SepetYemekler(int yemek_id, String yemek_ad, String yemek_resim_ad, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi) {
        this.yemek_id = yemek_id;
        this.yemek_ad = yemek_ad;
        this.yemek_resim_ad = yemek_resim_ad;
        this.yemek_fiyat = yemek_fiyat;
        this.yemek_siparis_adet = yemek_siparis_adet;
        this.kullanici_adi = kullanici_adi;
    }

    public int getYemek_id() {
        return yemek_id;
    }

    public void setYemek_id(int yemek_id) {
        this.yemek_id = yemek_id;
    }

    public String getYemek_ad() {
        return yemek_ad;
    }

    public void setYemek_ad(String yemek_ad) {
        this.yemek_ad = yemek_ad;
    }

    public String getYemek_resim_ad() {
        return yemek_resim_ad;
    }

    public void setYemek_resim_ad(String yemek_resim_ad) {
        this.yemek_resim_ad = yemek_resim_ad;
    }

    public int getYemek_fiyat() {
        return yemek_fiyat;
    }

    public void setYemek_fiyat(int yemek_fiyat) {
        this.yemek_fiyat = yemek_fiyat;
    }

    public int getYemek_siparis_adet() {
        return yemek_siparis_adet;
    }

    public void setYemek_siparis_adet(int yemek_siparis_adet) {
        this.yemek_siparis_adet = yemek_siparis_adet;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }
}
