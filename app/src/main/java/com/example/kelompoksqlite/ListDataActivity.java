package com.example.kelompoksqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Recycler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.kelompoksqlite.Database.DatabaseHelper;
import com.example.kelompoksqlite.Database.Mahasiswa;

import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CharSequence[] dialogItems = {"Lihat Data","Update Data", "Delete Data"};
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        recyclerView = findViewById(R.id.recycler_list_data);

        final DatabaseHelper db = new DatabaseHelper(this);
        List<Mahasiswa> mahasiswaList = db.selectUserData();
        final RecyclerAdapter adapter = new RecyclerAdapter(mahasiswaList);

        adapter.setListener(new RecyclerAdapter.Listener() {
            @Override
            public void onClick(int position) {
                gotoDetailActivity(recyclerView, position);
            }

        });
        adapter.setLongClickListener(new RecyclerAdapter.Listener() {
            @Override
            public void onClick(final int position) {
                final RecyclerAdapter.ViewHolder viewHolder = (RecyclerAdapter.ViewHolder)
                        recyclerView.findViewHolderForLayoutPosition(position);
                new AlertDialog.Builder(context)
                        .setTitle("Pilihan")
                        .setItems(dialogItems, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i) {
                                    case 0:
                                        gotoDetailActivity(recyclerView, position);
                                        break;
                                    case 1:
                                        gotoUpdateActivity(recyclerView, position);
                                    case 2:
                                        db.delete(Integer.valueOf(viewHolder.bean.getIdMahasiswa()));
                                }

                            }


                            private void gotoDetailActivity(RecyclerView recyclerView, int position) {
                                RecyclerAdapter.ViewHolder v = (RecyclerAdapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
                                Intent intent = new Intent(ListDataActivity.this, DetailDataActivity.class);
                                intent.putExtra("mahasiswa", v.bean);
                                startActivity(intent);

                            }

                            private void gotoUpdateActivity(RecyclerView recyclerView, int position) {
                                RecyclerAdapter.ViewHolder v = (RecyclerAdapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
                                Intent intent = new Intent(ListDataActivity.this, UpdateDataActivity.class);
                                intent.putExtra("mahasiswa", v.bean);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });

        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


    }
    private void gotoDetailActivity(RecyclerView recyclerView, int position) {
        RecyclerAdapter.ViewHolder v = (RecyclerAdapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
        Intent intent = new Intent(ListDataActivity.this, DetailDataActivity.class);
        intent.putExtra("mahasiswa", v.bean);
        startActivity(intent);

    }
}
