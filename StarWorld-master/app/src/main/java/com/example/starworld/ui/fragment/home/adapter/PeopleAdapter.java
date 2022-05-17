package com.example.starworld.ui.fragment.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starworld.databinding.ItemCardPeopleBinding;
import com.example.starworld.domain.model.people.PersonAboba;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
    private ItemCardPeopleBinding binding;
    private List<PersonAboba> list = new ArrayList<>();

    public void addList(List<PersonAboba> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCardPeopleBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new PeopleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {
        holder.onBind(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder {
        ItemCardPeopleBinding binding;

        public PeopleViewHolder(@NonNull ItemCardPeopleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(String name) {
            binding.txtCardPeople.setText(name);
        }
    }
}
