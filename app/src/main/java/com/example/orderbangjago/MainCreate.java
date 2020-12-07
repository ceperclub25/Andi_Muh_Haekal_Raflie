package com.example.orderbangjago;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ekelas;
    private TextView Ejumlah;
    private String Snama, Skelas,Sjumlah;
    private Button btnMenu;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ekelas = (EditText) findViewById(R.id.create_kelas);
        Ejumlah = (TextView) findViewById(R.id.create_jumlah);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Skelas = String.valueOf(Ekelas.getText());
                Sjumlah = String.valueOf(Ejumlah.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Isi Nama Pemesan",
                            Toast.LENGTH_SHORT).show();
                } else if (Skelas.equals("")){
                    Ekelas.requestFocus();
                    Toast.makeText(MainCreate.this, "Isi Menu Pesanan",
                            Toast.LENGTH_SHORT).show();
                } else if (Skelas.equals("")){
                    Ejumlah.requestFocus();
                    Toast.makeText(MainCreate.this, "Isi Jumlah Pesanan",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ekelas.setText("");
                    Ejumlah.setText("");
                    Toast.makeText(MainCreate.this, "Pesanan Berhasil, Silahkan Tunggu",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new Mahasiswa(null, Snama, Skelas,Sjumlah));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }

        });
    }
    public void increment(View view){
        if(quantity==100){
            Toast.makeText(this,"Pesanan Maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){
        if (quantity==1){
            Toast.makeText(this,"Pesanan Minimal 1",Toast.LENGTH_SHORT).show();
            return;

        }
        quantity = quantity -1;
        display(quantity);
    }
    private void display(int number) {
        TextView create_jumlah = (TextView) findViewById(R.id.create_jumlah);
        create_jumlah.setText("" + number);
    }
}
