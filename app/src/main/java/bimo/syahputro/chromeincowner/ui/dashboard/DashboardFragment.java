package bimo.syahputro.chromeincowner.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import bimo.syahputro.chromeincowner.R;
import bimo.syahputro.chromeincowner.network.responses.DashboardResponse;

public class DashboardFragment extends Fragment {

    DashboardViewModel viewModel;
    TextView tvTransaksi, tvSelesai, tvMenunggu, tvDikerjakan;

    View view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();

        viewModel.getDashboard().observe(getActivity(), new Observer<DashboardResponse>() {
            @Override
            public void onChanged(DashboardResponse dashboardResponse) {
                tvTransaksi.setText(dashboardResponse.getJumlahTransaksi());
                tvDikerjakan.setText(dashboardResponse.getJumlahDikerjakan());
                tvSelesai.setText(dashboardResponse.getJumlahSelesai());
                tvMenunggu.setText(dashboardResponse.getJumlahMenunggu());
            }
        });

    }

    private void init(){
        viewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        tvTransaksi = view.findViewById(R.id.tv_transaksi);
        tvDikerjakan = view.findViewById(R.id.tv_dikerjakan);
        tvSelesai = view.findViewById(R.id.tv_selesai);
        tvMenunggu = view.findViewById(R.id.tv_menunggu);
    }
}