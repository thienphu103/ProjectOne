package vn.edu.poly.project_one.view.view_visit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_visit_hangbanchay_kieulietke;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter_kieulietke;
import vn.edu.poly.project_one.view.ViSit;

/**
 * Created by ASUS on 11/21/2017.
 */

public class visit_hangbanchay_kieulietke extends Fragment {
    View view_visit_hangbanchay_kieulietke;
    ImageView img_kieulietke;
    GridView gridView;
    ArrayList<visit_hangbanchay_getter_setter_kieulietke> arrayList;
    Adapter_visit_hangbanchay_kieulietke adapter;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit_hangbanchay_kieulietke = inflater.inflate(R.layout.fragment_thamquan_hangbanchay_kieulietke, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_visit_hangbanchay_kieulietke;
    }

    private void initOnClick() {
        img_kieulietke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangbanchay visit_view = new visit_hangbanchay();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangbanchay_kieulietke, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

    private void initControl() {
        gridView = (GridView) view_visit_hangbanchay_kieulietke.findViewById(R.id.gridview_visit__hangbanchay_kieulietke_tablayoutactivity);
        img_kieulietke = (ImageView) view_visit_hangbanchay_kieulietke.findViewById(R.id.img_kieudanhsachlietke_visit_hangbanchay_tablayoutactivity);
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));
        arrayList.add(new visit_hangbanchay_getter_setter_kieulietke(R.drawable.giay_bike,
                getResources().getString(R.string.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity),
                getResources().getString(R.string.txt_gia_tablayoutactivity)
        ));

        adapter = new Adapter_visit_hangbanchay_kieulietke(getActivity(), arrayList);
        gridView.setAdapter(adapter);
    }
}
