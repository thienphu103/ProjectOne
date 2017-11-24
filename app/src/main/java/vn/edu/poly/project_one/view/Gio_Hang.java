package vn.edu.poly.project_one.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
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

/**
 * Created by ASUS on 11/18/2017.
 */

public class Gio_Hang extends android.support.v4.app.Fragment {
    View view_giohang;
    Context context;
    ArrayList<SanPham> sanPhamArrayList;
    Adapter_sanpham_giohang adapter_sanpham_giohang;
    GridView gridview_dathang_giohang, gridview_demuasau_giohang;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_giohang = inflater.inflate(R.layout.fragment_giohang, container, false);
        initControl();
        return view_giohang;
    }

    private void initControl() {
        context = getContext();
        sanPhamArrayList = new ArrayList<>();

        gridview_dathang_giohang = (GridView) view_giohang.findViewById(R.id.gridview_dathang_giohang);
        gridview_demuasau_giohang = (GridView) view_giohang.findViewById(R.id.gridview_demuasau_giohang);

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

        adapter_sanpham_giohang = new Adapter_sanpham_giohang(context, sanPhamArrayList);
        gridview_dathang_giohang.setAdapter(adapter_sanpham_giohang);
        gridview_demuasau_giohang.setAdapter(adapter_sanpham_giohang);
        setGridViewHeightBasedOnChildren(gridview_dathang_giohang, 1);
        setGridViewHeightBasedOnChildren(gridview_demuasau_giohang, 1);
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
