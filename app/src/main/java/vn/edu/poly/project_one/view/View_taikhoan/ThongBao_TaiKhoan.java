package vn.edu.poly.project_one.view.View_taikhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_ThongBao_TaiKhoan;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;
import vn.edu.poly.project_one.view.Tai_Khoan;

/**
 * Created by ASUS on 12/19/2017.
 */

public class ThongBao_TaiKhoan extends Fragment {
    View view_thongbao;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_ThongBao_TaiKhoan adapter;
    ListView listView;
    private View relativeLayout2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_thongbao = inflater.inflate(R.layout.fragment_thongbao, container, false);
        initControl();
        initEvent();
        return view_thongbao;
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        arrayList.add(new visit_1_getter_setter("THỨ TƯ, 20 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
        arrayList.add(new visit_1_getter_setter("THỨ NĂM, 21 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
        arrayList.add(new visit_1_getter_setter("THỨ SÁU, 22 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
        arrayList.add(new visit_1_getter_setter("THỨ BẢY, 23 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
        adapter = new Adapter_ThongBao_TaiKhoan(arrayList,getContext());
        listView.setAdapter(adapter);

        relativeLayout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Tai_Khoan DonHangcuaToi_TaiKhoan = new Tai_Khoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_thongbao, DonHangcuaToi_TaiKhoan, "sometag");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                return false;
            }
        });
    }

    private void initControl() {
        listView = (ListView) view_thongbao.findViewById(R.id.lst_thongbao);
        relativeLayout2=(RelativeLayout) view_thongbao.findViewById(R.id.layout_back_thongbao);
    }

}
