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

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mit.bitirmeodevi.R;
import com.mit.bitirmeodevi.databinding.FragmentAnasayfaBinding;
import com.mit.bitirmeodevi.ui.adapter.YemeklerAdapter;
import com.mit.bitirmeodevi.ui.viewmodel.AnasayfaViewModel;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false);

        binding.setAnasayfaToolbarBaslik("Yemekler");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarAnasayfa);

        viewModel.yemeklerListesi.observe(getViewLifecycleOwner(),yemeklerListesi -> {
            YemeklerAdapter adapter =new YemeklerAdapter(requireContext(),yemeklerListesi,viewModel);
            binding.setYemeklerAdapter(adapter);
        });

        binding.setAnasayfaFragment(this);

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) AnasayfaFragment.this);
            }
            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return binding.getRoot();
    }
    public void fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.anasayfa2sepet);
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
    @Override
    public void onResume() {
        super.onResume();
        viewModel.yemekleriYukle();

    }

}