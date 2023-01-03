package com.mit.bitirmeodevi.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.mit.bitirmeodevi.data.entity.CRUDCevap;
import com.mit.bitirmeodevi.data.entity.SepetYemekler;

import com.mit.bitirmeodevi.data.entity.SepetYemeklerCevap;
import com.mit.bitirmeodevi.retrofit.SepetYemeklerDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetYemeklerDaoRepository {
    private MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi;
    private SepetYemeklerDao sydao;

    public SepetYemeklerDaoRepository(SepetYemeklerDao sydao) {
        sepetYemeklerListesi = new MutableLiveData();
        this.sydao = sydao;
    }
    public MutableLiveData<List<SepetYemekler>> getSepetYemeklerListesi(){
        return sepetYemeklerListesi;
    }
    public void sepetYemeklerYukle(String kullanici_adi){

        sydao.sepetYemeklerYukle(kullanici_adi).enqueue(new Callback<SepetYemeklerCevap>() {


            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {
                List<SepetYemekler> liste = response.body().getSepetYemekler();
                sepetYemeklerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {

            }
        });

    }

    public void sil(int sepet_yemek_id, String kullanici_adi) {
        sydao.sil(sepet_yemek_id,kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void ekle(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi) {
        sydao.ekle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }
}
