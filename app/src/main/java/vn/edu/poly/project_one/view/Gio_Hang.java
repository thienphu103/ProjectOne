package vn.edu.poly.project_one.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_sanpham_giohang;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.SanPham;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 11/18/2017.
 */

public class Gio_Hang extends Fragment {
    View view_giohang;
    Context context;
    private RecyclerView mRecyclerView_giohang;
    private RecyclerView.Adapter mAdapter_giohang;
    private RecyclerView.LayoutManager mLayoutManager_giohang;
    private ArrayList<SanPham> sanPhamArrayList;
    private Adapter_sanpham_giohang adapter;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_giohang = inflater.inflate(R.layout.fragment_giohang, container, false);
        initEvent();
        initControl();

        return view_giohang;
    }

    private void initEvent() {
        mRecyclerView_giohang = (RecyclerView) view_giohang.findViewById(R.id.recyclerview_dathang_giohang);
        collapsingToolbarLayout = (CollapsingToolbarLayout) view_giohang.findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.txt_giohang_textview_tablayoutactivity));
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.black));
    }

    private void initControl() {
        sanPhamArrayList = new ArrayList<>();
        sanPhamArrayList.add(new SanPham("Vintas Lowtop",
                "360.000 VND", "2", "3",
                R.drawable.giay));

        sanPhamArrayList.add(new SanPham("Vintas Lowtop",
                "360.000 VND", "2", "3",
                R.drawable.giay));

        sanPhamArrayList.add(new SanPham("Vintas Lowtop",
                "360.giay VND", "2", "3",
                R.drawable.giay));

        sanPhamArrayList.add(new SanPham("Vintas Lowtop",
                "360.000 VND", "2", "3",
                R.drawable.giay));

        sanPhamArrayList.add(new SanPham("Vintas Lowtop",
                "360.000 VND", "2", "3",
                R.drawable.giay));

        mRecyclerView_giohang.setHasFixedSize(true);
        mLayoutManager_giohang = new LinearLayoutManager(getActivity());
        mRecyclerView_giohang.setLayoutManager(mLayoutManager_giohang);
        adapter = new Adapter_sanpham_giohang(getContext(),sanPhamArrayList);
        mRecyclerView_giohang.setAdapter(adapter);
    }

    public void setGridViewHeightBasedOnChildren(GridView gridView, int columns) {
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int items = listAdapter.getCount();
        int rows = 0;

        View listItem = listAdapter.getView(0, null, gridView);
        listItem.measure(0, 0);
        totalHeight = listItem.getMeasuredHeight();

        float x = 1;
        if( items > columns ){
            x = items/columns;
            rows = (int) (x + 1);
            totalHeight *= rows;
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);

    }
}
