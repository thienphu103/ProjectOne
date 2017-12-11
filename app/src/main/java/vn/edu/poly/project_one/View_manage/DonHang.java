package vn.edu.poly.project_one.View_manage;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.poly.project_one.R;

public class DonHang extends Fragment {
    View view_donhang;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_donhang = inflater.inflate(R.layout.fragment_don_hang, container, false);
        return view_donhang;
    }
}
