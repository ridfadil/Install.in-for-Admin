package com.example.fadil.admininstallin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fadil.admininstallin.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class DetailPemesananActivity extends AppCompatActivity implements View.OnClickListener {

    private CircularImageView imageProfile;
    private TextView txtKtpKurir;
    private TextView txtNamaKurir;
    private TextView noHp;
    private TextView txtNoHpKurir;
    private TextView txtStatusTransaksi;
    private TextView tvNamaOs;
    private TextView tvTipeOs;
    private TextView tvHargaOs;
    private ImageView imageOs;
    private RecyclerView rvDetailPesanan;
    private TextView txtNamaPemesan;
    private TextView txtAlamatPengambilan;
    private TextView txtTanggalPengembalian;
    private TextView txtWaktuPengembalian;
    private TextView txtNoPemesan;
    private TextView totalBiaya;
    private Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan);
        initView();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Pesanan");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        imageProfile = (CircularImageView) findViewById(R.id.image_profile);
        txtKtpKurir = (TextView) findViewById(R.id.txt_ktp_kurir);
        txtNamaKurir = (TextView) findViewById(R.id.txt_nama_kurir);
        noHp = (TextView) findViewById(R.id.no_hp);
        txtNoHpKurir = (TextView) findViewById(R.id.txt_no_hp_kurir);
        txtStatusTransaksi = (TextView) findViewById(R.id.txt_status_transaksi);
        tvNamaOs = (TextView) findViewById(R.id.tv_nama_os);
        tvTipeOs = (TextView) findViewById(R.id.tv_tipe_os);
        tvHargaOs = (TextView) findViewById(R.id.tv_harga_os);
        imageOs = (ImageView) findViewById(R.id.image_os);
        rvDetailPesanan = (RecyclerView) findViewById(R.id.rv_detail_pesanan);
        txtNamaPemesan = (TextView) findViewById(R.id.txt_nama_pemesan);
        txtAlamatPengambilan = (TextView) findViewById(R.id.txt_alamat_pengambilan);
        txtTanggalPengembalian = (TextView) findViewById(R.id.txt_tanggal_pengembalian);
        txtWaktuPengembalian = (TextView) findViewById(R.id.txt_waktu_pengembalian);
        txtNoPemesan = (TextView) findViewById(R.id.txt_no_pemesan);
        totalBiaya = (TextView) findViewById(R.id.total_biaya);
        btnDone = (Button) findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_done:
                break;
        }
    }
}
