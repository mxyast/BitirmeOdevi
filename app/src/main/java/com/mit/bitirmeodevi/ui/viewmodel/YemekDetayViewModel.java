package com.mit.bitirmeodevi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mit.bitirmeodevi.data.entity.SepetYemekler;
import com.mit.bitirmeodevi.data.repo.SepetYemeklerDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YemekDetayViewModel extends ViewModel {
    private SepetYemeklerDaoRepository syrepo;
    public MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi = new MutableLiveData<>();

    @Inject
    public YemekDetayViewModel(SepetYemeklerDaoRepository syrepo){
        this.syrepo = syrepo;
    }

    public void ekle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat,int yemek_siparis_adet,String kullanici_adi){
        syrepo.ekle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi);
    }
}
