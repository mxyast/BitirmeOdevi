package com.mit.bitirmeodevi.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.bitirmeodevi.R;
import com.mit.bitirmeodevi.data.entity.Yemekler;
import com.mit.bitirmeodevi.databinding.FragmentYemekDetayBinding;
import com.mit.bitirmeodevi.ui.viewmodel.YemekDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YemekDetayFragment extends Fragment {
public FragmentYemekDetayBinding binding;
public YemekDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false);
        binding.setYemekDetayToolbarBaslik("Yemekk Detay");

        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler gelenYemek = bundle.getYemekler();
        binding.setYemekNesnesi(gelenYemek);

        binding.setYemekDetayFragment(this);
        return binding.getRoot();
    }
    public void ekle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat,int yemek_siparis_adet,String kullanici_adi){
        viewModel.ekle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi);
    }
}