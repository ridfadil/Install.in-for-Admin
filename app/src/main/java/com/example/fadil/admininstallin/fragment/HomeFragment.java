package com.example.fadil.admininstallin.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.adapter.DaftarPesanAdapter;
import com.example.fadil.admininstallin.api.BaseApiService;
import com.example.fadil.admininstallin.model.DaftarPesanan;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    /*private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;*/
    private LinearLayout mLinearLayout;

    private FragmentActivity myContext;

    private RecyclerView rvHome;
    private DaftarPesanAdapter adapter;
    List<DaftarPesanan> listPesan = new ArrayList<>();

    ProgressDialog loading;

    BaseApiService apiService;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //sliderView = (SliderView) v.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) v.findViewById(R.id.pagesContainer);
        //setupSlider();

        rvHome = (RecyclerView) v.findViewById(R.id.rv_daftar_pesanan);

        adapter = new DaftarPesanAdapter(getContext(), listPesan);

//        apiService = UtilsApi.getAPIService();

        rvHome.setHasFixedSize(true);
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setAdapter(adapter);

        refresh();

        return v;
    }

    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        listPesan.add(new DaftarPesanan("1", "Windows 10", "Windows10", "Rp. 20.000", "X32","12-02-2018","13-02-2018","M Farid Padilah","Kuningan Jawabarat Rt/Rw 02/03"));
        listPesan.add(new DaftarPesanan("2", "Windows 7", "Windows10", "Rp. 20.000", "X32","12-02-2018","13-02-2018","M Farid Padilah","Kuningan Jawabarat Rt/Rw 02/03"));
        adapter.notifyDataSetChanged();
        loading.dismiss();
    }

    /*private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        mAdapter = new SliderPagerAdapter(myContext.getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getContext(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }*/
}
