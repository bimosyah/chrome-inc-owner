package bimo.syahputro.chromeincowner.ui.transaksiharian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bimo.syahputro.chromeincowner.R;

public class TransaksiHarianFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_transaksi_harian, container, false);
        return root;
    }
}