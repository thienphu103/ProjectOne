package vn.edu.poly.project_one.view.View_taikhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_donhangcuatoi_taikhoan;
import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 11/28/2017.
 */

public class HoSoCuaToi_TaiKhoan extends Fragment {
    View view_taikhoan_hosocuatoi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_taikhoan_hosocuatoi = inflater.inflate(R.layout.fragment_hosocuatoi_taikhoan, container, false);
        initControl();
        initEvent();
        return view_taikhoan_hosocuatoi;
    }

    private void initEvent() {
    }

    private void initControl() {
    }


}
