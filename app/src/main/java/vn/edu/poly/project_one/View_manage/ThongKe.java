package vn.edu.poly.project_one.View_manage;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_Khohang;
import vn.edu.poly.project_one.Adapter.Adapter_thongke;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

public class ThongKe extends Fragment {
    View view_thongke;
    ListView listView;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_thongke adapter_thongke;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_thongke = inflater.inflate(R.layout.fragment_thong_ke, container, false);
        initControl();
        initEvent();
        return view_thongke;
    }

    private void initControl() {
        listView = (ListView) view_thongke.findViewById(R.id.lst_thongke);
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        for(int i = 0; i< 10;i++) {
            arrayList.add(new visit_1_getter_setter());
        }
        adapter_thongke = new Adapter_thongke(getActivity(),arrayList);
        listView.setAdapter(adapter_thongke);
    }
}
