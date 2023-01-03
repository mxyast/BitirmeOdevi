package com.mit.bitirmeodevi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mit.bitirmeodevi.data.entity.Yemekler;
import com.mit.bitirmeodevi.data.repo.YemeklerDaoRepository;
import com.mit.bitirmeodevi.data.entity.Yemekler;
import com.mit.bitirmeodevi.data.repo.YemeklerDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel  extends ViewModel {
    private YemeklerDaoRepository yrepo;
    public MutableLiveData<List<Yemekler>> yemeklerListesi = new MutableLiveData<>();


    @Inject
    public AnasayfaViewModel(YemeklerDaoRepository yrepo){
        this.yrepo = yrepo;
        yemekleriYukle();
        yemeklerListesi=yrepo.getYemeklerListesi();

    }

    public void yemekleriYukle(){
        yrepo.yemekleriYukle();
    }
}
