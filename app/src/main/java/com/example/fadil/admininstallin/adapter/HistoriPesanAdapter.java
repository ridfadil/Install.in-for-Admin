package com.example.fadil.admininstallin.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.model.DaftarPesanan;
import com.example.fadil.admininstallin.model.HistoriPesanan;

import java.util.List;

public class HistoriPesanAdapter extends RecyclerView.Adapter<HistoriPesanAdapter.ViewHolder> {


    private Context context;
    private List<HistoriPesanan> listHistori;

    public HistoriPesanAdapter(Context context, List<HistoriPesanan> listHistori) {
        this.context = context;
        this.listHistori = listHistori;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history_transaksi, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HistoriPesanan pesan = listHistori.get(position);
        Glide.with(context)
                .load(pesan.getImageOs()) //ganti sama Model image
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageOS);
        holder.namaKurir.setText(pesan.getNamaKurir());
        holder.tglAmbil.setText(pesan.getTgTransaksi());
        holder.tglSelesai.setText(pesan.getTglselesai());
        holder.alamat.setText(pesan.getAlamat());
        holder.txtNamaOS.setText(pesan.getNamaOs());
        holder.txtTipeOS.setText(pesan.getTipeOs());
        holder.txtHargaOS.setText(pesan.getHargaOs());
        holder.cvPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + pesan.getIdHistori(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.terima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "terima", Toast.LENGTH_SHORT).show();
            }
        });
        holder.tolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "tolak", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHistori.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvPesan;

        private TextView txtNamaOS, txtTipeOS, txtHargaOS, tglSelesai, alamat, tglAmbil, namaKurir;
        private Button terima, tolak;
        private ImageView imageOS;

        public ViewHolder(View itemView) {
            super(itemView);

            tglSelesai = itemView.findViewById(R.id.tv_tanggal_selesai);
            alamat = itemView.findViewById(R.id.tv_alamat_kirim);
            tglAmbil = itemView.findViewById(R.id.tv_tgl_ambil);
            namaKurir = itemView.findViewById(R.id.tv_nama_kurir);
            terima = itemView.findViewById(R.id.btn_terima);
            tolak = itemView.findViewById(R.id.btn_tolak);
            cvPesan = itemView.findViewById(R.id.cv_daftar_pesanan);
            txtNamaOS = itemView.findViewById(R.id.tv_nama_os);
            txtTipeOS = itemView.findViewById(R.id.tv_tipe_os);
            txtHargaOS = itemView.findViewById(R.id.tv_harga_os);
            imageOS = itemView.findViewById(R.id.iv_image_os);
        }
    }
}