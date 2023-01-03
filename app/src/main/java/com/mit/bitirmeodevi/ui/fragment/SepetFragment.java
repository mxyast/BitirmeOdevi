package com.mit.bitirmeodevi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mit.bitirmeodevi.R;
import com.mit.bitirmeodevi.databinding.FragmentSepetBinding;
import com.mit.bitirmeodevi.ui.adapter.SepetYemeklerAdapter;
import com.mit.bitirmeodevi.ui.adapter.YemeklerAdapter;
import com.mit.bitirmeodevi.ui.viewmodel.SepetViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SepetFragment extends Fragment {
    private FragmentSepetBinding binding;
    private SepetViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false);

        binding.setSepetToolbarBaslik("Yemekler");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarSepet);

        viewModel.sepetYemeklerListesi.observe(getViewLifecycleOwner(),sepetYemeklerListesi -> {
            SepetYemeklerAdapter adapter =new SepetYemeklerAdapter(requireContext(),sepetYemeklerListesi,viewModel);
            binding.setSepetYemeklerAdapter(adapter);
        });

        binding.setSepetFragment(this);

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener((SearchView.OnQueryTextListener)SepetFragment.this);
            }
            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return binding.getRoot();
    }
    public void fabTikla(){
        Log.e("ödeme adımı","ödeme");
    }
}