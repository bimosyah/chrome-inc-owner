package ninda.sabilla.chromeincowner.ui.transaksiharian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.List;

import ninda.sabilla.chromeincowner.R;
import ninda.sabilla.chromeincowner.network.entity.Transaksi;
import ninda.sabilla.chromeincowner.network.responses.TransaksiHarianResponse;

public class TransaksiHarianFragment extends Fragment {
    View view;
    TransaksiHarianViewModel viewModel;
    AnyChartView anyChartView;
    List<Transaksi> transaksiList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_transaksi_harian, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        viewModel.getTransaksiHarian().observe(getActivity(), new Observer<TransaksiHarianResponse>() {
            @Override
            public void onChanged(TransaksiHarianResponse transaksiHarianResponse) {
                transaksiList = transaksiHarianResponse.getTransaksiList();
                chart();
            }
        });
    }

    private void chart() {
        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(false)
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

        cartesian.title("Grafik Transaksi Harian.");

        cartesian.yAxis(0).title("Transaksi");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);

        List<DataEntry> seriesData = new ArrayList<>();
        for (Transaksi transaksi : transaksiList) {
            seriesData.add(new ValueDataEntry(transaksi.getTanggal(), Integer.parseInt(transaksi.getJumlah())));
        }

        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");

        Line series1 = cartesian.line(series1Mapping);
        series1.name("Transaksi");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series1.tooltip()
                .position("right")
                .offsetX(5d)
                .offsetY(5d);

        cartesian.legend().enabled(true);
        cartesian.legend().fontSize(13d);
        cartesian.legend().padding(0d, 0d, 10d, 0d);

        anyChartView.setChart(cartesian);
    }


    private void init() {
        viewModel = ViewModelProviders.of(this).get(TransaksiHarianViewModel.class);
        anyChartView = view.findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(view.findViewById(R.id.progress_bar));
    }

}