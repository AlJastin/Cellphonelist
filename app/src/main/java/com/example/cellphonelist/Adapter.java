package com.example.cellphonelist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private ArrayList phone_model_id, price_id, os_id, specs_id;

    public Adapter(Context context, ArrayList phone_model_id, ArrayList price_id, ArrayList os_id, ArrayList specs_id) {
        this.context = context;
        this.phone_model_id = phone_model_id;
        this.price_id = price_id;
        this.os_id = os_id;
        this.specs_id = specs_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.phone_model_id.setText(String.valueOf(phone_model_id.get(position)));
        holder.price_id.setText(String.valueOf(price_id.get(position)));
        holder.os_id.setText(String.valueOf(os_id.get(position)));
        holder.specs_id.setText(String.valueOf(specs_id.get(position)));

        // Set click listener for the delete button
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the delete function when the delete button is clicked
                deleteItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return phone_model_id.size();
    }


    // Method to delete an item from the RecyclerView
    private void deleteItem(int position) {
        phone_model_id.remove(position);
        price_id.remove(position);
        os_id.remove(position);
        specs_id.remove(position);
        notifyDataSetChanged();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView phone_model_id, price_id, os_id, specs_id;
        ImageView btnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            phone_model_id = itemView.findViewById(R.id.text_phone_model);
            price_id = itemView.findViewById(R.id.text_price);
            os_id = itemView.findViewById(R.id.text_os);
            specs_id = itemView.findViewById(R.id.text_SPECS);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}

