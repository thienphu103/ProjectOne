package vn.edu.poly.project_one.view.view_today;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import java.util.ArrayList;
import vn.edu.poly.project_one.Adapter.Adapter_khaitruong_today;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.today_khaitruong_setter_getter;
import vn.edu.poly.project_one.fragment_sign_up.fragment_sign_up_2;

/**
 * Created by ASUS on 11/23/2017.
 */

public class today_khaitruong extends Fragment {
    View view_khaitruong;
    ArrayList<today_khaitruong_setter_getter> arrayList;
    ListView listView;
    Adapter_khaitruong_today adapter;
    FrameLayout frameLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_khaitruong = inflater.inflate(R.layout.fragment_today_khaitruong, container, false);
        FragmentManager fragment = getFragmentManager();
        today_khaitruong today_khaitruong = (today_khaitruong) fragment.findFragmentById(R.id.fragment_today_2);
        FragmentTransaction ft = fragment.beginTransaction();
        ft.hide(today_khaitruong);
        ft.commit();
        initControl();
        initEvent();
        initOnClick();
        return view_khaitruong;
    }

    private void initOnClick() {
//      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//          @Override
//          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              FragmentManager fragment = getFragmentManager();
//              today_custom3 today_custom3 = (today_custom3) fragment.findFragmentById(R.id.fragment_today_3);
//              FragmentTransaction ft = fragment.beginTransaction();
//              ft.show(today_custom3);
//              ft.commit();
//          }
//      });
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragment = getFragmentManager();
                today_custom3 today_custom3 = (today_custom3) fragment.findFragmentById(R.id.fragment_today_3);
                FragmentTransaction ft = fragment.beginTransaction();
                ft.show(today_custom3);
                ft.commit();
            }
        });
    }

    private void initControl() {
        listView = (ListView) view_khaitruong.findViewById(R.id.lst_today_khaitruong);
        frameLayout = (FrameLayout) view_khaitruong.findViewById(R.id.fragment_today_khaitruong);
    }
    private void initEvent() {
        arrayList = new ArrayList<>();
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));

        adapter = new Adapter_khaitruong_today(getActivity(),arrayList);
        listView.setAdapter(adapter);

    }

}
