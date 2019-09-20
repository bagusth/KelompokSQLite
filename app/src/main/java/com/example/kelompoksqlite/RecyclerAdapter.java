package com.example.kelompoksqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelompoksqlite.Database.Mahasiswa;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<Mahasiswa> mahasiswaList;
    private Listener listener;
    private Listener longClickListener;

    public RecyclerAdapter(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView card = (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_list,
                parent,
                false
        );
        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, final int position) {
        CardView card = holder.card;
        holder.bean = mahasiswaList.get(position);

        TextView textNama = card.findViewById(R.id.txt_card_nama);
        textNama.setText(holder.bean.getNama());

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
        card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (longClickListener != null) {
                    longClickListener.onClick(position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
    public void setLongClickListener(Listener listener) {
        this.longClickListener =  listener;
    }

    public interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        Mahasiswa bean;
        public ViewHolder(CardView card) {
            super(card);
            this.card = card;
        }
    }
}

