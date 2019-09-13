package com.example.kelompoksqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kelompoksqlite.Database.Mahasiswa;
import com.example.kelompoksqlite.Database.DatabaseHelper;

public class InputDataActivity extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;
    TextView textSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        nomorInput = findViewById(R.id.NomerInputDet);
        namaInput = findViewById(R.id.InputNamaDet);
        tglLahirInput = findViewById(R.id.InputTglLahirDet);
        jenkelInput = findViewById(R.id.InputJenkelDet);
        alamatInput = findViewById(R.id.InputAlamatDet);
        textSave = findViewById(R.id.txtUpdate);

        final DatabaseHelper db = new DatabaseHelper(this);

        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insert(new Mahasiswa(
                        Integer.valueOf(nomorInput.getText().toString()),
                        namaInput.getText().toString(),
                        tglLahirInput.getText().toString(),
                        jenkelInput.getText().toString(),
                        alamatInput.getText().toString()
                ));

            }
        });
    }
}
