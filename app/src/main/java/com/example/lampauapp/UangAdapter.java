package com.example.lampauapp; // Ganti dengan package name Anda

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UangAdapter extends RecyclerView.Adapter<UangAdapter.UangViewHolder> {

    private List<Uang> listUang;
    private Context context;
    private OnItemClickCallback onItemClickCallback;

    public UangAdapter(List<Uang> listUang, Context context) {
        this.listUang = listUang;
        this.context = context;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public UangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_uang, parent, false);
        return new UangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UangViewHolder holder, int position) {
        Uang uang = listUang.get(position);
        holder.tvNominal.setText(uang.getNominal());

        // Handle klik item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listUang.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUang.size();
    }

    public static class UangViewHolder extends RecyclerView.ViewHolder {
        TextView tvNominal;

        public UangViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNominal = itemView.findViewById(R.id.tv_item_nominal);
        }
    }

    // Interface untuk callback klik item
    public interface OnItemClickCallback {
        void onItemClicked(Uang data);
    }
}