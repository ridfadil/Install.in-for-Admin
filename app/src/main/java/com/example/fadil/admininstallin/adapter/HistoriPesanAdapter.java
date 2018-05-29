package com.example.fadil.admininstallin.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.model.HistoriPesanan;

import java.util.List;

import butterknife.BindView;

public class HistoriPesanAdapter extends RecyclerView.Adapter<HistoriPesanAdapter.ViewHolder> {


    CardView cvDaftarHistory;
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
                .into(holder.tivImageOsHistory);
        holder.tvKurirHistori.setText(pesan.getNamaKurir());
        holder.tvNamaHistori.setText(pesan.getNamaPelanggan());
        holder.tvHargaOsHistory.setText(pesan.getHargaOs());
        holder.tvAlamatHistori.setText(pesan.getAlamat());
        holder.tvProgressHistori.setText(pesan.getStatus());
        holder.tvNamaOsHistory.setText(pesan.getNamaOs());
        holder.tvTipeOsHistory.setText(pesan.getTipeOs());
        holder.tvTanggalSekarangHistory.setText(pesan.getTgTransaksi());
        holder.tvTanggalSelesaiHistory.setText(pesan.getTglselesai());

    }

    @Override
    public int getItemCount() {
        return listHistori.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvPesan;

        private TextView tvNamaOsHistory,tvTipeOsHistory,tvTanggalSelesaiHistory,tvHargaOsHistory,tvAlamatHistori,tvNamaHistori,tvProgressHistori,tvKurirHistori,tvTanggalSekarangHistory;
        private ImageView tivImageOsHistory;
        private CardView cdView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNamaOsHistory =itemView.findViewById(R.id.tv_nama_os_history);
            tvTipeOsHistory = itemView.findViewById(R.id.tv_tipe_os_history);
            tvTanggalSelesaiHistory = itemView.findViewById(R.id.tv_tanggal_selesai_history);
            tvHargaOsHistory = itemView.findViewById(R.id.tv_harga_os_history);
            tvAlamatHistori = itemView.findViewById(R.id.tv_alamat_histori);
            tvNamaHistori = itemView.findViewById(R.id.tv_nama_histori);
            tvProgressHistori = itemView.findViewById(R.id.tv_progress_histori);
            tvKurirHistori = itemView.findViewById(R.id.tv_kurir_histori);
            tvTanggalSekarangHistory = itemView.findViewById(R.id.tv_tanggal_sekarang_history);
            tivImageOsHistory = itemView.findViewById(R.id.iv_image_os_history);

        }
    }
}