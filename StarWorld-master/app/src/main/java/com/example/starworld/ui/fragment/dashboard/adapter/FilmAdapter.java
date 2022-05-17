package com.example.starworld.ui.fragment.dashboard.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starworld.databinding.ItemCardBinding;
import com.example.starworld.domain.model.film.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {
    private List<Film> list = new ArrayList<>();
    ItemCardBinding binding;


    public void setList(List<Film> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.onBind(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {
        ItemCardBinding binding;

        public FilmViewHolder(@NonNull ItemCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(String title) {
            binding.txtCard.setText(title);
        }
    }
}
