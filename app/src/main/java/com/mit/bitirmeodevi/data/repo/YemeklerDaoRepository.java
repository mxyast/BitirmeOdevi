package com.mit.bitirmeodevi.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.mit.bitirmeodevi.data.entity.CRUDCevap;
import com.mit.bitirmeodevi.data.entity.Yemekler;
import com.mit.bitirmeodevi.data.entity.YemeklerCevap;
import com.mit.bitirmeodevi.retrofit.YemeklerDao;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemeklerDaoRepository {
    private MutableLiveData<List<Yemekler>> yemeklerListesi;
    private YemeklerDao ydao;

    public YemeklerDaoRepository(YemeklerDao ydao) {
        yemeklerListesi =new MutableLiveData();
        this.ydao = ydao;
    }
    public MutableLiveData<List<Yemekler>> getYemeklerListesi(){
        return yemeklerListesi;
    }


    public void yemekleriYukle(){
        ydao.yemekleriYukle().enqueue(new Callback<YemeklerCevap>() {
            @Override
            public void onResponse(Call<YemeklerCevap> call, Response<YemeklerCevap> response) {
                List<Yemekler> liste = response.body().getYemekler();
                yemeklerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<YemeklerCevap> call, Throwable t) {

            }

        });

    }
}
