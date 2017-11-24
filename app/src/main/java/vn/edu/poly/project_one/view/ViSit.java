package vn.edu.poly.project_one.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.ImageAdapter_visit;
import vn.edu.poly.project_one.Adapter.MyAdapter_visit;
import vn.edu.poly.project_one.Adapter.MyAdapter_visit_2;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.fragment_sign_up.fragment_sign_up_3;
import vn.edu.poly.project_one.view.view_visit.visit_danhsachcuahang;
import vn.edu.poly.project_one.view.view_visit.visit_hangbanchay;
import vn.edu.poly.project_one.view.view_visit.visit_hangmoi_kieudanhsach;

/**
 * Created by ASUS on 11/18/2017.
 */

public class ViSit extends Fragment {
    View view_visit;
    TextView txt_hangbanchay_tablayoutactivity,txt_hangmoi_tablayoutactivty;
    TextView txt_danhsachcuahang_tablayoutactivity;
    GridView gridview_visit;
    private RecyclerView mRecyclerView_visit;
    private RecyclerView.Adapter mAdapter_visit;
    private RecyclerView.LayoutManager mLayoutManager_visit;
    private ArrayList<String> strings;
    private RecyclerView mRecyclerView_visit_2;
    private RecyclerView.Adapter mAdapter_visit_2;
    private RecyclerView.LayoutManager mLayoutManager_visit_2;
    private ArrayList<String> strings_2;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit = inflater.inflate(R.layout.fragment_thamquan, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_visit;
    }

    private void initOnClick() {
        txt_hangbanchay_tablayoutactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangbanchay visit_hangbanchay = new visit_hangbanchay();
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.fragmelayout_visit,visit_hangbanchay);
                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft1.addToBackStack(null);
                ft1.commit();
            }
        });
        txt_danhsachcuahang_tablayoutactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_danhsachcuahang visit_view=new visit_danhsachcuahang();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmelayout_visit, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        txt_hangmoi_tablayoutactivty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangmoi_kieudanhsach visit_view=new visit_hangmoi_kieudanhsach();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmelayout_visit, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

    private void initControl(){
        mRecyclerView_visit = (RecyclerView) view_visit.findViewById(R.id.my_recycler_view_visit);
        mRecyclerView_visit_2 = (RecyclerView) view_visit.findViewById(R.id.my_recycler_view_visit_2);
        gridview_visit = (GridView) view_visit.findViewById(R.id.gridview_visit_tablayoutactivity);
        txt_hangbanchay_tablayoutactivity =
                (TextView) view_visit.findViewById(R.id.txt_viewall_hangbanchay_tablayoutactivity);
        txt_danhsachcuahang_tablayoutactivity =
                (TextView) view_visit.findViewById(R.id.txt_viewall_danhsachcuahang_tablayoutactivity);
        txt_hangmoi_tablayoutactivty =
                (TextView) view_visit.findViewById(R.id.txt_viewall_hangmoi_tablayoutactivity);
    }
    private void initEvent() {
        strings = new ArrayList<>();
        for(int i = 0 ; i < 10 ;i++){
            strings.add(getResources().getString(R.string.txt_tenhang_tablayoutactivity));
        }
        strings_2 = new ArrayList<>();
        for(int i = 0 ; i < 10 ;i++){
            strings_2.add(getResources().getString(R.string.txt_tenhang_tablayoutactivity));
        }
        mRecyclerView_visit.setHasFixedSize(true);
        mLayoutManager_visit = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_visit.setLayoutManager(mLayoutManager_visit);
        mAdapter_visit = new MyAdapter_visit(strings);
        mRecyclerView_visit.setAdapter(mAdapter_visit);
        mRecyclerView_visit_2.setHasFixedSize(true);
        mLayoutManager_visit_2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_visit_2.setLayoutManager(mLayoutManager_visit_2);
        mAdapter_visit_2 = new MyAdapter_visit_2(strings_2);
        mRecyclerView_visit_2.setAdapter(mAdapter_visit_2);
        gridview_visit.setAdapter(new ImageAdapter_visit(getActivity()));
        setGridViewHeightBasedOnChildren(gridview_visit,3);
        collapsingToolbarLayout = (CollapsingToolbarLayout) view_visit.findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.txt_visit_tablayoutactivity));
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.black));

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
