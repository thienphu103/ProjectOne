package vn.edu.poly.project_one.view.View_taikhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_danhsachmongmuon_taikhoan;
import vn.edu.poly.project_one.Adapter.Adapter_danhsachyeuthich_taikhoan;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.taikhoan_danhsachmongmuon_getter_setter;
import vn.edu.poly.project_one.View_getter_setter.taikhoan_danhsachyeuthich_getter_setter;

/**
 * Created by ASUS on 11/28/2017.
 */

public class DanhSachMongMuon_TaiKhoan extends Fragment {
    View view_danhsachmongmuon;
    GridView gridView;
    ArrayList arrayList;
    Adapter_danhsachmongmuon_taikhoan adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_danhsachmongmuon = inflater.inflate(R.layout.fragment_danhsachmongmuon_taikhoan, container, false);
        initControl();
        initEvent();
        return view_danhsachmongmuon;
    }

    private void initEvent() {
        arrayList = new ArrayList();
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachmongmuon_getter_setter(R.drawable.giay_bike));
        if (getActivity() != null) {
            adapter = new Adapter_danhsachmongmuon_taikhoan(getActivity(), arrayList);
            gridView.setAdapter(adapter);
        }

    }

    private void initControl() {
        gridView = (GridView) view_danhsachmongmuon.findViewById(R.id.gridview_danhsachmongmuon_taikhoan);
    }


}
