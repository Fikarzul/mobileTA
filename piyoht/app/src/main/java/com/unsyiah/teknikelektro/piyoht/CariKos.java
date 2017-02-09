package com.unsyiah.teknikelektro.piyoht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * Created by Muhammad Yussuf on 1/25/2017.
 */


public class CariKos extends AppCompatActivity {

    Spinner spinKota, spinKecamatan;
    String PilihKota, PilihKecamatan;
    String[] pilihkota = {"Pilih Kota", "Banda Aceh", "Lhoksemawe"};
    String[] pilihkecamatan = {"Pilih Kecamatan", "Ulekareeng", "Darussalam"};
    String tempKota,tempKecamatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carikos);






        Button lokasi=(Button)findViewById(R.id.lokasi);
        lokasi.setOnClickListener(new View.OnClickListener() {



            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent a =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(a);

            }

        });

        Button cari=(Button)findViewById(R.id.cari);
        cari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent a =new Intent(getApplicationContext(),ListKos.class);
                startActivity(a);
            }});

        // Untuk Menampilkan isi Spinner
        spinKota = (Spinner) findViewById(R.id.pkota);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihkota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinKota.setAdapter(adapter);
        spinKota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                tempKota = pilihkota[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        // Untuk Menampilkan isi Spinner
        spinKecamatan = (Spinner) findViewById(R.id.pkecamatan);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihkecamatan);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinKecamatan.setAdapter(adapter1);
        spinKecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                tempKecamatan = pilihkecamatan[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        cari = (Button) findViewById(R.id.cari);
        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PilihKota = tempKota.toString();
                PilihKecamatan = tempKecamatan.toString();
                // Intent digunakan untuk pindah halaman.
                // i.putExtra digunakan untuk menyisipkan pesan pada Intent ketika berpindah halaman.
                Intent i = new Intent(getApplicationContext(), ListKos.class);
                i.putExtra("PilihKota", PilihKota);
                i.putExtra("PilihKecamatan", PilihKecamatan);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
