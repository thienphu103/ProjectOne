package vn.edu.poly.project_one.view.view_giohang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_3_dathang_giohang;
import vn.edu.poly.project_one.Adapter.Adapter_khaitruong_today;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_3_dathang extends Fragment {
    View view_dathang;
    ListView listView;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_3_dathang_giohang adapter;
    Button btn_continue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_dathang = inflater.inflate(R.layout.fragment_3_dathang_giohang, container, false);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        return view_dathang;
    }

    private void initOnClick() {
    }

    private void initDisplay() {
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        arrayList.add(new visit_1_getter_setter("Tên sản phẩm",
                "360.000 vnd",
                "1x", "tên cửa hàng"));
        arrayList.add(new visit_1_getter_setter("Tên sản phẩm",
                "360.000 vnd",
                "1x", "tên cửa hàng"));
        adapter = new Adapter_3_dathang_giohang(getActivity(),arrayList);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giohang_4_final  giohang_4_final =new  giohang_4_final();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_3_dathang,  giohang_4_final);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    private void initControl() {
        btn_continue = (Button) view_dathang.findViewById(R.id.btn_muahang_thanhtoan_giohang);
        listView = (ListView) view_dathang.findViewById(R.id.lst_3_dathang_giohang);
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        Adapter_3_dathang_giohang listAdapter = (Adapter_3_dathang_giohang) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }

            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
