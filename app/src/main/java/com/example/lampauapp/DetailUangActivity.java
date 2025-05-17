package com.example.lampauapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailUangActivity extends AppCompatActivity {

    public static final String EXTRA_UANG_NOMINAL = "extra_uang_nominal";
    public static final String EXTRA_UANG_DESKRIPSI = "extra_uang_deskripsi";
    public static final String EXTRA_UANG_PHOTO = "extra_uang_photo";

    ImageView imgUang;
    TextView tvNominalDetail, tvDeskripsiDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_uang);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Aktifkan tombol back

        imgUang = findViewById(R.id.img_uang);
        tvNominalDetail = findViewById(R.id.tv_nominal_detail);
        tvDeskripsiDetail = findViewById(R.id.tv_deskripsi_detail);

        // Ambil data dari Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nominal = extras.getString(EXTRA_UANG_NOMINAL);
            String deskripsi = extras.getString(EXTRA_UANG_DESKRIPSI);
            int photoResourceId = extras.getInt(EXTRA_UANG_PHOTO);

            // Tampilkan data
            tvNominalDetail.setText(nominal);
            tvDeskripsiDetail.setText(deskripsi);
            imgUang.setImageResource(photoResourceId);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
