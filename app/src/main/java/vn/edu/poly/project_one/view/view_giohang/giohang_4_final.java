package vn.edu.poly.project_one.view.view_giohang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_4_final extends Fragment {
    View view_final;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_final = inflater.inflate(R.layout.fragment_4_final_giohang, container, false);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        return view_final;
    }

    private void initOnClick() {
    }

    private void initDisplay() {
    }

    private void initEvent() {
    }

    private void initControl() {
    }
}
