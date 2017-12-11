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
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

public class KhoHang extends Fragment {
    View view_khohang;
    ListView listView;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_Khohang adapter_khohang;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_khohang = inflater.inflate(R.layout.fragment_kho_hang, container, false);
        initControl();
        initEvent();
        return view_khohang;
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        for(int i = 0; i< 10;i++) {
            arrayList.add(new visit_1_getter_setter());
        }
        adapter_khohang = new Adapter_Khohang(getActivity(),arrayList);
        listView.setAdapter(adapter_khohang);
    }

    private void initControl() {
        listView = (ListView) view_khohang.findViewById(R.id.lst_khohang);
    }
}
