package com.example.kelompoksqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kelompoksqlite.Database.Mahasiswa;
import com.example.kelompoksqlite.Database.DatabaseHelper;


public class UpdateDataActivity extends AppCompatActivity {
    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;
    TextView textSave;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        nomorInput = findViewById(R.id.NomerInputDet);
        namaInput = findViewById(R.id.InputNamaDet);
        tglLahirInput = findViewById(R.id.InputTglLahirDet);
        jenkelInput = findViewById(R.id.InputJenkelDet);
        alamatInput = findViewById(R.id.InputAlamatDet);
        textSave = findViewById(R.id.txtSave);
        context = this;

        Mahasiswa mahasiswa = getIntent().getParcelableExtra("mahasiswa");
        nomorInput.setText(mahasiswa.getIdMahasiswa()+"");
        namaInput.setText(mahasiswa.getNama());
        tglLahirInput.setText(mahasiswa.getTglLahir());
        jenkelInput.setText(mahasiswa.getJenKel());
        alamatInput.setText(mahasiswa.getAlamat());

        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);
                db.update(new Mahasiswa(
                        Integer.valueOf(nomorInput.getText().toString()),
                        namaInput.getText().toString(),
                        tglLahirInput.getText().toString(),
                        jenkelInput.getText().toString(),
                        alamatInput.getText().toString()
                ));
                Intent intent = new Intent(context, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}