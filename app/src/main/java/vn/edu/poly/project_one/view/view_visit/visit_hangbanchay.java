package vn.edu.poly.project_one.view.view_visit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.MyAdapter_visit_hangbanchay;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter;

/**
 * Created by ASUS on 11/20/2017.
 */

public class visit_hangbanchay extends Fragment {
    View view_visit_hangbanchay;
    GridView gridView;
    MyAdapter_visit_hangbanchay adapter;
    ArrayList<visit_hangbanchay_getter_setter> arrayList;
    ImageView img_kieudanhsach;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit_hangbanchay = inflater.inflate(R.layout.fragment_thamquan_hangbanchay, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_visit_hangbanchay;
    }

    private void initOnClick() {
        img_kieudanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangbanchay_kieulietke visit_view=new visit_hangbanchay_kieulietke();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangbanchay, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

    private void initControl() {
        img_kieudanhsach = (ImageView) view_visit_hangbanchay.findViewById(R.id.img_kieudanhsachlietke_visit_hangbanchay_tablayoutactivity);
        gridView = (GridView) view_visit_hangbanchay.findViewById(R.id.gridview_visit__hangbanchay_tablayoutactivity);
        arrayList = new ArrayList<>();
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangbanchay_getter_setter(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        adapter = new MyAdapter_visit_hangbanchay(getContext(),arrayList);
        gridView.setAdapter(adapter);

    }
    private void initEvent() {


//        FragmentManager fm = getFragmentManager();
//        visit_hangbanchay visit_hangbanchay  = (visit_hangbanchay) fm.findFragmentById(R.id.fragment_visit_hangbanchay);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.hide( visit_hangbanchay);
//        ft.commit();
    }
}
