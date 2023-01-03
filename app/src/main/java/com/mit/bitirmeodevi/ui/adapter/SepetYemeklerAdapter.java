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
import com.mit.bitirmeodevi.databinding.SepetCardTasarimBinding;
import com.mit.bitirmeodevi.ui.fragment.AnasayfaFragmentDirections;
import com.mit.bitirmeodevi.ui.viewmodel.SepetViewModel;

import java.util.List;

public class SepetYemeklerAdapter extends RecyclerView.Adapter<SepetYemeklerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<SepetYemekler> sepetYemeklerListesi;
    private SepetViewModel viewModel;

    public SepetYemeklerAdapter(Context mContext, List<SepetYemekler> sepetYemeklerListesi, SepetViewModel viewModel) {
        this.mContext = mContext;
        this.sepetYemeklerListesi = sepetYemeklerListesi;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SepetCardTasarimBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.sepet_card_tasarim,parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        SepetYemekler sepetYemekler = sepetYemeklerListesi.get(position);
        SepetCardTasarimBinding t = holder.binding;
        t.setSepetYemeklerNesnesi(sepetYemekler);

        t.satirSepetCard.setOnClickListener(view -> {

        });

        t.imageViewSepetSil.setOnClickListener(view -> {
            Snackbar.make(view,sepetYemekler.getYemek_ad()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("EVET",view1 -> {
                        viewModel.sil(sepetYemekler.getYemek_id(),sepetYemekler.getKullanici_adi());
                    }).show();
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private SepetCardTasarimBinding binding;
        public CardTasarimTutucu(SepetCardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
