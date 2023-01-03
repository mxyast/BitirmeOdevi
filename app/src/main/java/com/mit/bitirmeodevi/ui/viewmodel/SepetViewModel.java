package com.mit.bitirmeodevi.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mit.bitirmeodevi.data.entity.SepetYemekler;
import com.mit.bitirmeodevi.data.entity.Yemekler;
import com.mit.bitirmeodevi.data.repo.SepetYemeklerDaoRepository;


import java.io.Closeable;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SepetViewModel extends ViewModel {
    private SepetYemeklerDaoRepository syrepo;
    public MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi = new MutableLiveData<>();

    @Inject
    public SepetViewModel(SepetYemeklerDaoRepository syrepo){
        this.syrepo = syrepo;
        sepetYemekleriYukle();
        sepetYemeklerListesi = syrepo.getSepetYemeklerListesi();
    }

    public void sil(int yemek_id, String kullanici_adi){
        syrepo.sil(yemek_id,kullanici_adi);
    }


    public void sepetYemekleriYukle(){
        syrepo.sepetYemeklerYukle("mm");
    }

}
