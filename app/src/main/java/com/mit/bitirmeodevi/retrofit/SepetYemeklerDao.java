package com.mit.bitirmeodevi.retrofit;

import com.mit.bitirmeodevi.data.entity.CRUDCevap;
import com.mit.bitirmeodevi.data.entity.SepetYemeklerCevap;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SepetYemeklerDao {
    @POST("yemekler/sepettekiYemekleriGetir.php")
    Call<SepetYemeklerCevap> sepetYemeklerYukle(@Field("kullanici_adi") String kullanici_adi);

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    Call<CRUDCevap> sil(@Field("yemek_id") int yemek_id,
                        @Field("kullanici_adi") String kullanici_adi);

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<CRUDCevap> ekle(@Field("yemek_adi")            String yemek_adi,
                         @Field("yemek_resim_adi")      String yemek_resim_adi,
                         @Field("yemek_fiyat")          int yemek_fiyat,
                         @Field("yemek_siparis_adet")   int yemek_siparis_adet,
                         @Field("kullanici_adi")        String kullanici_adi);


}
