package vn.edu.poly.project_one.View_manage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_listview_donhang_manage;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

public class DonHang extends Fragment {
    View view_donhang;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_listview_donhang_manage adapter_listview_donhang_manage;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_donhang = inflater.inflate(R.layout.fragment_don_hang, container, false);
        initControl();
        initEvent();
        return view_donhang;
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        arrayList.add(new visit_1_getter_setter(R.color.colorPrimaryDark,"Đã Đóng Gói","Khách","thienphu103@gmail.com",R.color.color_background_loginactivity_signupactivity));
        arrayList.add(new visit_1_getter_setter(R.color.color_text_textview_email_SignUpactivity,"Đang Chuyển","Khách","thienphu103@gmail.com",R.color.color_text_textview_email_SignUpactivity));
        arrayList.add(new visit_1_getter_setter(R.color.cardview_dark_background,"Thành Công","Khách","thienphu103@gmail.com",R.color.color_text_textview_email_SignUpactivity));
//        arrayList.add(new visit_1_getter_setter(R.color.cardview_dark_background));
//        arrayList.add(new visit_1_getter_setter(R.color.cardview_light_background));
        adapter_listview_donhang_manage = new Adapter_listview_donhang_manage(getActivity(),arrayList);
        listView.setAdapter(adapter_listview_donhang_manage);
        adapter_listview_donhang_manage.notifyDataSetChanged();
    }


    private void initControl() {
        listView = (ListView) view_donhang.findViewById(R.id.lst_donhang);
    }
}
