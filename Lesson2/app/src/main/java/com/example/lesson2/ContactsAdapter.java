package com.example.lesson2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    {
    private layoutinflater inflater;
    private List<ContactModel> ;
}
public ContactsAdapter(layoutinflater inflater) {
    this.inflater = inflater;
}



    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_contacts, parent, false)
        return ;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ContactsViewHolder extends RecyclerView.ViewHolder{
        TextView txtContactName, txtContactPhone;
        Button btnMassage, btnCall;

        public ContactsViewHilder(@NonNull View itemView) {
            super(itemView);
            txtContactName = itemView.findViewById(R.id.txt_item_contact_name);
            txtContactName = itemView.findViewById(R.id.txt_item_contact_phone);
            txtContactName = itemView.findViewById(R.id.btn_call);
            txtContactName = itemView.findViewById(R.id.btn_massage);
        }
    }

}
