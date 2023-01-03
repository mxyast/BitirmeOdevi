package com.mit.bitirmeodevi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.mit.bitirmeodevi.R;
import com.mit.bitirmeodevi.data.entity.SepetYemekler;
import com.mit.bitirmeodevi.data.entity.Yemekler;
import com.mit.bitirmeodevi.databinding.CardTasarimBinding;
import com.mit.bitirmeodevi.ui.fragment.AnasayfaFragmentDirections;
import com.mit.bitirmeodevi.ui.viewmodel.AnasayfaViewModel;
import com.mit.bitirmeodevi.ui.viewmodel.SepetViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YemeklerAdapter extends RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Yemekler> yemeklerListesi;
    private AnasayfaViewModel viewModel;

    public YemeklerAdapter(Context mContext, List<Yemekler> yemeklerListesi, AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.yemeklerListesi = yemeklerListesi;
        this.viewModel = viewModel;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding binding;
        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim,parent,false);
        return new YemeklerAdapter.CardTasarimTutucu(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        Yemekler yemekler = yemeklerListesi.get(position);
        CardTasarimBinding t = holder.binding;
        t.setYemeklerNesnesi(yemekler);
        String url="http://kasimadalan.pe.hu/yemekler/resimler/"+yemekler.getYemek_resim_ad();
        Picasso.get().load(url).into(t.imageViewYemekResimAdi);
        t.satirYemekCard.setOnClickListener(view -> {
            AnasayfaFragmentDirections.Anasayfa2detay gecis =
                    AnasayfaFragmentDirections.anasayfa2detay(yemekler);
            Navigation.findNavController(view).navigate(gecis);
        });



    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
