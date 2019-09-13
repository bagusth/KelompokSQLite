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

public class RecyclerAdapter extends RecyclerView.Adapter {

    List<Mahasiswa> mahasiswaList;
    private DashboardActivity.Listener listener;
    private DashboardActivity.Listener longClickListener;

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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView card = holder.card;
        holder.bean = Mahasiswa.getPosition();

        TextView textNama = card.findViewById(R.id.recycler_list_data);
        textNama.setText(mahasiswaList.get(position).getNama());

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
        this.listener = (DashboardActivity.Listener) listener;
    }
    public void setLongClickListener(Listener listener) {
        this.longClickListener = (DashboardActivity.Listener) listener;
    }

    public interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Object mahasiswa;
        CardView card;
        Mahasiswa bean;
        public ViewHolder(CardView card) {
            super(card);
            this.card = card;
        }
    }
}
}
