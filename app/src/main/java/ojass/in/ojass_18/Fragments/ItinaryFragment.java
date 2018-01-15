package ojass.in.ojass_18.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ojass.in.ojass_18.R;

/**
 * Created by Stan on 1/15/2018.
 */

public class ItinaryFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itinary, container, false);
        return view;
    }
}
