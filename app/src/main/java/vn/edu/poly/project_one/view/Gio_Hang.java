package vn.edu.poly.project_one.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_sanpham_giohang;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.SanPham;
import vn.edu.poly.project_one.view.view_giohang.giohang_1_diachigiaohang;

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
    Button btn_dathang;
    private TextView txt_sum;
    Context myContext,appContext;
    private Bundle arguments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_giohang = inflater.inflate(R.layout.fragment_giohang, container, false);
        initEvent();
        initControl();
        initOnClick();
        return view_giohang;
    }

    private void initOnClick() {

        btn_dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giohang_1_diachigiaohang giohang_1_diachigiaohang = new giohang_1_diachigiaohang();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentlayout_giohang, giohang_1_diachigiaohang);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

    private void initEvent() {
        mRecyclerView_giohang = (RecyclerView) view_giohang.findViewById(R.id.recyclerview_dathang_giohang);
        collapsingToolbarLayout = (CollapsingToolbarLayout) view_giohang.findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.txt_giohang_textview_tablayoutactivity));
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.black));
        btn_dathang = (Button) view_giohang.findViewById(R.id.btn_dathang_giohang);
        txt_sum=(TextView) view_giohang.findViewById(R.id.txt_dathang_giohang);
    }

    private void initControl() {
        sanPhamArrayList = new ArrayList<>();
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details_index", MODE_PRIVATE);
//        int index = sharedPreferences.getInt("index", 0);
//        layoutView = inflater.inflate(R.layout.activity_doctor_list,container);
//        for (int i = 1; i < index; index++) {
//            SharedPreferences sharedPreferences_data = getContext().getSharedPreferences("post_details_gh", MODE_PRIVATE);
////            SharedPreferences.Editor editor_index = sharedPreferences_data.edit();
////            editor_index.putInt("index",index );
////            editor_index.commit();
//            String name = sharedPreferences_data.getString("name_sp_"+index, null);
//            String price = sharedPreferences_data.getString("gia_sp_"+index, null);
//            String url=sharedPreferences_data.getString("hinhanh_sp_"+index,null);
//
//            sanPhamArrayList.add(new SanPham(name,
//                    price, "2", "3",
//                    url));
//            Log.d("index", index + name);
//
//        }
        
        txt_sum.setText("Có "+sanPhamArrayList.size()+" Sản Phẩm Trong Giỏ Hàng");
        mRecyclerView_giohang.setHasFixedSize(true);
        mLayoutManager_giohang = new LinearLayoutManager(getActivity());
        mRecyclerView_giohang.setLayoutManager(mLayoutManager_giohang);
        adapter = new Adapter_sanpham_giohang(getContext(), sanPhamArrayList);
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
        if (items > columns) {
            x = items / columns;
            rows = (int) (x + 1);
            totalHeight *= rows;
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);

    }
}
