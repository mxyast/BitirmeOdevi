package com.mit.bitirmeodevi.retrofit;

import com.mit.bitirmeodevi.data.entity.YemeklerCevap;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YemeklerDao {
    @GET("yemekler/sepettekiYemekleriGetir.php")
    Call<YemeklerCevap> yemekleriYukle();

}
