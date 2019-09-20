package com.example.kelompoksqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.kelompoksqlite.Database.Mahasiswa;

public class DetailDataActivity extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        nomorInput = findViewById(R.id.NomerInputDet);
        namaInput = findViewById(R.id.InputNamaDet);
        tglLahirInput = findViewById(R.id.NomerInputDet);
        jenkelInput = findViewById(R.id.InputJenkelDet);
        alamatInput = findViewById(R.id.InputAlamatDet);

        Mahasiswa mahasiswa = getIntent().getParcelableExtra("mahasiswa");


        getSupportActionBar().setTitle(mahasiswa.getTglLahir());

        nomorInput.setText(mahasiswa.getIdMahasiswa()+"");
        namaInput.setText(mahasiswa.getNama());
        tglLahirInput.setText(mahasiswa.getTglLahir());
        jenkelInput.setText(mahasiswa.getJenKel());
        alamatInput.setText(mahasiswa.getAlamat());
    }
}
