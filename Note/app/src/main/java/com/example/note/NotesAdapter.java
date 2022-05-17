package com.example.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private List<NotesModel> list = new ArrayList<>();
    OnItem onItem;

    public NotesAdapter(OnItem onItem) {
        this.onItem = onItem;
    }

    public void addNote(NotesModel model) {
        list.add(model);
        notifyDataSetChanged();
    }

    public List<NotesModel> getList() {
        return list;
    }

    public void changeNote(int position, NotesModel model) {
        list.set(position, model);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes,
                parent,
                false);
        return new NotesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDescription.setText(list.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItem.click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDescription;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_item_title);
            txtDescription = itemView.findViewById(R.id.txt_item_description);
        }
    }
}
