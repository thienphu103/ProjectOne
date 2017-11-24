package vn.edu.poly.project_one.view.view_visit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.project_one.Adapter.Adapter_visit_danhsachcuahang;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_danhsachcuahang_getter_setter;

/**
 * Created by ASUS on 11/21/2017.
 */

public class visit_danhsachcuahang extends Fragment {
    View view_visit_danhsachcuahang;
    ListView listView;
    Adapter_visit_danhsachcuahang adapter;
    ArrayList<visit_danhsachcuahang_getter_setter> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit_danhsachcuahang = inflater.inflate(R.layout.fragment_thamquan_danhsachcuahang, container, false);
        initControl();
        initEvent();
        return view_visit_danhsachcuahang;
    }

    private void initControl() {
        listView = (ListView) view_visit_danhsachcuahang.findViewById(R.id.lst_fragment_visit_hangbanchay_tablayoutactivity);
    }
    private void initEvent() {

        arrayList = new ArrayList<>();
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new visit_danhsachcuahang_getter_setter(getResources().getString(R.string.txt_beyeu_tablayoutactivity)
                ,getResources().getString(R.string.txt_mevabe_tablayoutactivity),getResources().getString(R.string.btn_vao_tablayoutactivity)));
        adapter = new Adapter_visit_danhsachcuahang(arrayList,getContext());
        listView.setAdapter(adapter);


//        FragmentManager fm = getFragmentManager();
//        visit_hangbanchay visit_hangbanchay  = (visit_hangbanchay) fm.findFragmentById(R.id.fragment_visit_hangbanchay);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.hide( visit_hangbanchay);
//        ft.commit();
    }

}
