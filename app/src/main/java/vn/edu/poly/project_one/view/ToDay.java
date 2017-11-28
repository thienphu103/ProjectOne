package vn.edu.poly.project_one.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_cardview_today;
import vn.edu.poly.project_one.Adapter.Adapter_khaitruong_today;
import vn.edu.poly.project_one.Adapter.ImageAdapter_visit;
import vn.edu.poly.project_one.Adapter.MyAdapter_visit;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.today_khaitruong_setter_getter;
import vn.edu.poly.project_one.fragment_sign_up.fragment_sign_up_2;

/**
 * Created by ASUS on 11/18/2017.
 */

public class ToDay extends Fragment {
    View view_today;
    ArrayList<today_khaitruong_setter_getter> arrayList;
    ListView listView;
    Adapter_khaitruong_today adapter;
    private RecyclerView mRecyclerView_today;
    private RecyclerView.Adapter mAdapter_today;
    private RecyclerView.LayoutManager mLayoutManager_today;
    private ArrayList<String> strings;
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view_today = inflater.inflate(R.layout.fragment_today, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_today;
    }

    private void initOnClick() {
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
        setListViewHeightBasedOnChildren(listView);

        strings = new ArrayList<>();
        for(int i = 0 ; i < 8 ;i++){
            strings.add(getResources().getString(R.string.txt_giaynam));
        }
        mRecyclerView_today.setHasFixedSize(true);
        mLayoutManager_today = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_today.setLayoutManager(mLayoutManager_today);
        mAdapter_today = new Adapter_cardview_today(strings);
        mRecyclerView_today.setAdapter(mAdapter_today);
    }

    private void initControl() {
        listView = (ListView) view_today.findViewById(R.id.lst_today_khaitruong);
        mRecyclerView_today = (RecyclerView) view_today.findViewById(R.id.my_recycler_view_today);

    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        Adapter_khaitruong_today listAdapter = (Adapter_khaitruong_today) listView.getAdapter();
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
