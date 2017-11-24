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

import vn.edu.poly.project_one.Adapter.Adapter_visit_hangmoi_kieudanhsach;
import vn.edu.poly.project_one.Adapter.MyAdapter_visit_hangbanchay;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter;
import vn.edu.poly.project_one.View_getter_setter.visit_hangmoi_getter_setter_kieudanhsach;

/**
 * Created by ASUS on 11/23/2017.
 */

public class visit_hangmoi_kieudanhsach extends Fragment {
    View view_visit_hangmoi_kieudanhsach;
    GridView gridView;
    Adapter_visit_hangmoi_kieudanhsach adapter;
    ArrayList<visit_hangmoi_getter_setter_kieudanhsach> arrayList;
    ImageView img_kieudanhsach;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit_hangmoi_kieudanhsach = inflater.inflate(R.layout.fragment_visit_hangmoi_kieudanhsach, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_visit_hangmoi_kieudanhsach;
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        arrayList.add(new
                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)));
        adapter = new Adapter_visit_hangmoi_kieudanhsach(getActivity(),arrayList);
        gridView.setAdapter(adapter);
    }
    private void initControl() {
        img_kieudanhsach = (ImageView) view_visit_hangmoi_kieudanhsach.findViewById(R.id.img_kieudanhsachlietke_visit_hangmoi_kieudanhsach_tablayoutactivity);
        gridView = (GridView) view_visit_hangmoi_kieudanhsach.findViewById(R.id.gridview_visit_hangmoi_kieudanhsach);

    }
    private void initOnClick() {
        img_kieudanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangmoi_kieulietke visit_view=new   visit_hangmoi_kieulietke();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangmoi_kieudanhsach, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

}
