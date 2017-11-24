package vn.edu.poly.project_one.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 11/18/2017.
 */

public class Tai_Khoan extends android.support.v4.app.Fragment {
    View view_taikhoan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_taikhoan = inflater.inflate(R.layout.fragment_taikhoan, container, false);
        return view_taikhoan;
    }
}
