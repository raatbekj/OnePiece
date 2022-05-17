package com.example.starworld.ui.fragment.notifications.adapter;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starworld.databinding.ItemCardPlanetBinding;
import com.example.starworld.domain.model.planets.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    private List<Planet> list = new ArrayList<>();
    private ItemCardPlanetBinding binding;


    public void addList(List<Planet> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCardPlanetBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new PlanetViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        holder.onBind(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PlanetViewHolder extends  RecyclerView.ViewHolder {
        ItemCardPlanetBinding binding;
        public PlanetViewHolder(@NonNull ItemCardPlanetBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(String name) {
            binding.txtCardPlanet.setText(name);
        }
    }
}
