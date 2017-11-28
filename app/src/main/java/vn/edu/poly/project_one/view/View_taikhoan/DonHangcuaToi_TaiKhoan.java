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
 * Created by ASUS on 11/26/2017.
 */

public class DonHangcuaToi_TaiKhoan extends Fragment {
    View view_taikhoan_donhangcuatoi;
    GridView gridView;
    ArrayList arrayList;
    Adapter_donhangcuatoi_taikhoan adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_taikhoan_donhangcuatoi = inflater.inflate(R.layout.fragment_donhangcuatoi_taikhoan, container, false);
        initControl();
        initEvent();
        return view_taikhoan_donhangcuatoi;
    }

    private void initEvent() {
        arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add("");
        }
        adapter = new Adapter_donhangcuatoi_taikhoan(getActivity(),arrayList);
        gridView.setAdapter(adapter);

    }

    private void initControl() {
        gridView = (GridView) view_taikhoan_donhangcuatoi.findViewById(R.id.gridview_donhangcuatoi_taikhoan_tablayoutactivity);
    }

}
