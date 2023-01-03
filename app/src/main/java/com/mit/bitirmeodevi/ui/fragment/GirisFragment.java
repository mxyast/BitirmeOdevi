package com.mit.bitirmeodevi.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.bitirmeodevi.R;
import com.mit.bitirmeodevi.databinding.FragmentGirisBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GirisFragment extends Fragment {
private FragmentGirisBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding =FragmentGirisBinding.inflate(inflater);
       binding.buttonGiris.setOnClickListener(view->{
           Navigation.findNavController(view).navigate(R.id.giris2anasayfa);
       });

       binding.editTextKullaniciAdi.getText();

        return binding.getRoot();
    }
}