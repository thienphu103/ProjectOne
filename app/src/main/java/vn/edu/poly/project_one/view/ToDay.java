package vn.edu.poly.project_one.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import vn.edu.poly.project_one.Adapter.ImageAdapter_visit;
import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 11/18/2017.
 */

public class ToDay extends Fragment {
    View view_today;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view_today = inflater.inflate(R.layout.fragment_today, container, false);
        return view_today;
    }
}
