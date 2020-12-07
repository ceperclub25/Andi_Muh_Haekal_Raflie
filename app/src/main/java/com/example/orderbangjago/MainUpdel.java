package com.example.orderbangjago;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Skelas,Sjumlah;
    private EditText Enama, Ekelas,Ejumlah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Skelas = i.getStringExtra("Ikelas");
        Sjumlah = i.getStringExtra("Ijumlah");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ekelas = (EditText) findViewById(R.id.updel_kelas);
        Ejumlah = (EditText) findViewById(R.id.updel_jumlah);
        Enama.setText(Snama);
        Ekelas.setText(Skelas);
        Ejumlah.setText(Sjumlah);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Skelas = String.valueOf(Ekelas.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Isi Nama Pemesan",
                            Toast.LENGTH_SHORT).show();
                } else if (Skelas.equals("")){
                    Ekelas.requestFocus();
                    Toast.makeText(MainUpdel.this, "Isi Menu Pesanan",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjumlah.equals("")){
                    Ejumlah.requestFocus();
                    Toast.makeText(MainUpdel.this, "Isi Jumlah Pesanan",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new Mahasiswa(Sid, Snama, Skelas, Sjumlah));
                    Toast.makeText(MainUpdel.this, "Pesanan Di Perbarui",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new Mahasiswa(Sid, Snama, Skelas,Sjumlah));
                Toast.makeText(MainUpdel.this, "Pesanan Di Hapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
