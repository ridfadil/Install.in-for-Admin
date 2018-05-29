package com.example.fadil.admininstallin.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.adapter.HistoriPesanAdapter;
import com.example.fadil.admininstallin.api.BaseApiService;
import com.example.fadil.admininstallin.model.HistoriPesanan;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private RecyclerView rvHistory;
    private HistoriPesanAdapter adapter;
    List<HistoriPesanan> listHistory = new ArrayList<>();

    ProgressDialog loading;

    BaseApiService apiService;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);

        rvHistory = (RecyclerView) v.findViewById(R.id.rv_history);

        adapter = new HistoriPesanAdapter(getContext(), listHistory);

//        apiService = UtilsApi.getAPIService();

        rvHistory.setHasFixedSize(true);
        rvHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHistory.setAdapter(adapter);

        refresh();

        return v;
    }

    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        listHistory.add(new HistoriPesanan("1", "Windows 10", "x64", "Rp. 20.000", "", "28 Januari 2018", "27-02-2018","Fadil","Tania","Jl Raya Cinunuk no 54","On Progress"));
        listHistory.add(new HistoriPesanan("2", "Linux", "x64", "Rp. 20.000", "", "28 Januari 2018", "27-02-2018","Fadil","Tania","Jl Raya Cinunuk no 54","On Progress"));
        listHistory.add(new HistoriPesanan("2", "Linux", "x64", "Rp. 20.000", "", "28 Januari 2018", "27-02-2018","Fadil","Tania","Jl Raya Cinunuk no 54","On Progress"));
        adapter.notifyDataSetChanged();
        loading.dismiss();
    }

}
