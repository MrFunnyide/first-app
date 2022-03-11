package com.example.tugas1_ajibayupermadi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etKodeBarang, etJumlahBarang;
    private Button btnHtng;
    private TextView tvHasil, tvHasilNB, tvHasilHB, tvHasilTH, tvDicHasil, tvHasilJB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);

        etKodeBarang =  findViewById(R.id.etKodeBarang);
        etJumlahBarang = findViewById(R.id.etJumlahBarang);
        btnHtng = findViewById(R.id.btnHtng);
        tvHasil = findViewById(R.id.tvHasil);
        tvHasilNB = findViewById(R.id.tvHasilNB);
        tvHasilHB = findViewById(R.id.tvhasilHB);
        tvHasilTH = findViewById(R.id.tvHasilTH);
        tvDicHasil = findViewById(R.id.tvDicHasil);
        tvHasilJB = findViewById(R.id.tvHasilJB);


        btnHtng.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnHtng) {
            // calculate
            String KodeBarang = etKodeBarang.getText().toString().trim();
            String JumlahBarang = etJumlahBarang.getText().toString().trim();

            String barang = KodeBarang.substring(0, 3).toUpperCase(Locale.ROOT);
            int hargaBarang;
            String NmBarang;

            int discount = 0;
            discount = Integer.parseInt(KodeBarang.substring(3));

            switch (barang) {
                case "AND":
                    NmBarang = "Android";
                    hargaBarang = 1000000;
                    break;
                case "IOS":
                    NmBarang = "Apple";
                    hargaBarang = 2000000;
                    break;
                case "BLB":
                    NmBarang = "Black Berry";
                    hargaBarang = 1750000;
                    break;
                case "WNP":
                    NmBarang = "Windows Phone";
                    hargaBarang = 2500000;
                    break;
                default:
                    NmBarang = "Barang tidak tersedia";
                    hargaBarang = 0;
            }
            // rumus
            boolean isianKosong = false;
            if (TextUtils.isEmpty(KodeBarang)) {
                isianKosong = true;
                etKodeBarang.setError("Isian Kode Barang tidak boleh kosong");
            }
            if (TextUtils.isEmpty(JumlahBarang)) {
                isianKosong = true;
                etJumlahBarang.setError("Isian Jumlah Barang tidak boleh kosong");
            }
            if (!isianKosong) {

                // Nama Barang
                String NB = String.valueOf(NmBarang);
                tvHasilNB.setText((String.valueOf(NB)));

                // Harga Barang
                double HB = Double.valueOf(hargaBarang);
                tvHasilHB.setText(String.valueOf(HB));

                // Total Harga
                Double TH = Double.valueOf(hargaBarang) * Double.valueOf(JumlahBarang);
                tvHasilTH.setText(String.valueOf(TH));

                // Discount
                double disc = (TH * discount) / 100;
                tvDicHasil.setText(String.valueOf(disc));

                // jumlah bayar
                double JB = TH - disc;
                tvHasilJB.setText(String.valueOf(JB));
            }
        }
    }
}