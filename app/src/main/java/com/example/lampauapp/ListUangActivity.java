package com.example.lampauapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ListUangActivity extends AppCompatActivity {

    private RecyclerView rvUang;
    private List<Uang> listUang = new ArrayList<>(); // Buat class Uang nanti

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_uang);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvUang = findViewById(R.id.rv_uang);
        rvUang.setHasFixedSize(true);

        // Siapkan data uang (contoh data)
        listUang.addAll(getDataUang());

        // Siapkan Adapter dan tampilkan di RecyclerView
        UangAdapter adapter = new UangAdapter(listUang, this); // Buat class UangAdapter nanti
        rvUang.setLayoutManager(new LinearLayoutManager(this));
        rvUang.setAdapter(adapter);

        // Atur listener klik item di Adapter (implementasinya di UangAdapter)
        adapter.setOnItemClickCallback(new UangAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Uang data) {
                // Pindah ke DetailUangActivity dan kirim data Uang
                Intent intent = new Intent(ListUangActivity.this, DetailUangActivity.class);
                intent.putExtra(DetailUangActivity.EXTRA_UANG_NOMINAL, data.getNominal());
                intent.putExtra(DetailUangActivity.EXTRA_UANG_DESKRIPSI, data.getDeskripsi());
                intent.putExtra(DetailUangActivity.EXTRA_UANG_PHOTO, data.getPhotoResourceId());
                startActivity(intent);
            }
        });
    }

    private List<Uang> getDataUang() {
        List<Uang> uangList = new ArrayList<>();

        // Data Uang Kertas Rupiah Indonesia beserta Tokoh, Deskripsi Lengkap, dan Sejarah Singkat
        uangList.add(new Uang("100.000",
                "Depan: Ir. Soekarno dan Dr. (H.C.) Drs. Mohammad Hatta (Proklamator Kemerdekaan Indonesia, Presiden dan Wakil Presiden pertama RI).\n" +
                        "Belakang: Tari Topeng Betawi dan Keindahan Alam Raja Ampat.\n\n" +
                        "Sejarah Singkat: Nominal tertinggi Rupiah, seringkali menampilkan proklamator sebagai simbol persatuan dan kemerdekaan.",
                R.drawable.uang100ribu)); // Pastikan Anda memiliki file uang100ribu.png/jpg di res/drawable

        uangList.add(new Uang("50.000",
                "Depan: Ir. H. Djuanda Kartawidjaja (Perdana Menteri Indonesia ke-10).\n" +
                        "Belakang: Tari Legong dan Keindahan Alam Taman Nasional Komodo.\n\n" +
                        "Sejarah Singkat: Djuanda dikenal dengan Deklarasi Djuanda yang memperluas wilayah perairan Indonesia.",
                R.drawable.uang50ribu)); // Pastikan Anda memiliki file uang50ribu.png/jpg di res/drawable

        uangList.add(new Uang("20.000",
                "Depan: Dr. G.S.S.J. Ratulangi (Gubernur Sulawesi pertama).\n" +
                        "Belakang: Tari Gong dan Keindahan Alam Derawan.\n\n" +
                        "Sejarah Singkat: Ratulangi adalah tokoh pendidikan dan pahlawan dari Sulawesi.",
                R.drawable.uang20ribu)); // Pastikan Anda memiliki file uang20ribu.png/jpg di res/drawable

        uangList.add(new Uang("10.000",
                "Depan: Frans Kaisiepo (Pahlawan Nasional dari Papua).\n" +
                        "Belakang: Tari Pakarena dan Keindahan Alam Taman Nasional Wakatobi.\n\n" +
                        "Sejarah Singkat: Kaisiepo berperan penting dalam perjuangan penyatuan Irian Barat ke dalam wilayah Indonesia.",
                R.drawable.uang10ribu)); // Pastikan Anda memiliki file uang10ribu.png/jpg di res/drawable

        uangList.add(new Uang("5.000",
                "Depan: Dr. K.H. Idham Chalid (Ketua MPR/DPR RI dan Pahlawan Nasional).\n" +
                        "Belakang: Tari Gambyong dan Keindahan Alam Gunung Bromo.\n\n" +
                        "Sejarah Singkat: Idham Chalid adalah tokoh agama dan politik yang berperan dalam masa awal kemerdekaan.",
                R.drawable.uang5ribu)); // Pastikan Anda memiliki file uang5ribu.png/jpg di res/drawable

        uangList.add(new Uang("2.000",
                "Depan: Mohammad Hoesni Thamrin (Tokoh Betawi, Pahlawan Nasional).\n" +
                        "Belakang: Tari Piring dan Keindahan Alam Ngarai Sianok.\n\n" +
                        "Sejarah Singkat: Hoesni Thamrin adalah tokoh pergerakan nasional yang memperjuangkan hak-hak pribumi di Volksraad.",
                R.drawable.uang2ribu)); // Pastikan Anda memiliki file uang2ribu.png/jpg di res/drawable

        uangList.add(new Uang("1.000",
                "Depan: Tjut Meutia (Pahlawan Nasional dari Aceh).\n" +
                        "Belakang: Tari Tifa dan Keindahan Alam Banda Neira.\n\n" +
                        "Sejarah Singkat: Tjut Meutia adalah pejuang wanita yang memimpin perlawanan terhadap penjajah di Aceh.",
                R.drawable.uang1ribu)); // Pastikan Anda memiliki file uang1ribu.png/jpg di res/drawable

        return uangList;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Kembali ke Activity sebelumnya
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}