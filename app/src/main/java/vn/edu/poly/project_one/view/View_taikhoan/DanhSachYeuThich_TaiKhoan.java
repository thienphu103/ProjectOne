package vn.edu.poly.project_one.view.View_taikhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_danhsachyeuthich_taikhoan;
import vn.edu.poly.project_one.Adapter.Adapter_donhangcuatoi_taikhoan;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.taikhoan_danhsachyeuthich_getter_setter;

/**
 * Created by ASUS on 11/28/2017.
 */

public class DanhSachYeuThich_TaiKhoan extends Fragment {
    View view_danhsachyeuthich;
    GridView gridView;
    ArrayList arrayList;
    Adapter_danhsachyeuthich_taikhoan adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_danhsachyeuthich = inflater.inflate(R.layout.fragment_danhsachyeuthich_taikhoan, container, false);
        initControl();
        initEvent();
        return view_danhsachyeuthich;
    }

    private void initEvent() {
        arrayList = new ArrayList();
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.images_2));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.images_2));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.images_2));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.images_2));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.giay_bike));
        arrayList.add(new taikhoan_danhsachyeuthich_getter_setter(R.drawable.images_2));
        if (getActivity() != null) {
            adapter = new Adapter_danhsachyeuthich_taikhoan(getActivity(), arrayList);
            gridView.setAdapter(adapter);
        }
    }

    private void initControl() {
        gridView = (GridView) view_danhsachyeuthich.findViewById(R.id.gridview_danhsachyeuthich_taikhoan);
    }


}
