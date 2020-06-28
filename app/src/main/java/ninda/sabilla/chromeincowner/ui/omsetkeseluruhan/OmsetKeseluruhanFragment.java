package ninda.sabilla.chromeincowner.ui.omsetkeseluruhan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ninda.sabilla.chromeincowner.R;

public class OmsetKeseluruhanFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_omset_keseluruhan, container, false);
        return root;
    }
}