package bimo.syahputro.chromeincowner.ui.omsetharian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bimo.syahputro.chromeincowner.R;

public class OmsetHarianFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_omset_harian, container, false);
        return root;
    }
}