package vn.edu.poly.project_one.View_manage;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_trungbay_cuahang_manage;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

public class CuaHang extends Fragment {
    View view_cuahang;
    private RecyclerView mRecyclerView_cuahang;
    private RecyclerView.Adapter mAdapter_cuahang;
    private RecyclerView.LayoutManager mLayoutManager_cuahang;
    private ArrayList<visit_1_getter_setter> cuahang;
    //Trưng bày
    private RecyclerView mRecyclerView_hangbanchay_cuahang;
    private RecyclerView.Adapter mAdapter_hangbanchay_cuahang;
    private RecyclerView.LayoutManager mLayoutManager_hangbanchay_cuahang;
    private ArrayList<visit_1_getter_setter> hangbanchay_cuahang;
    // Hàng bán chạy
    private RecyclerView mRecyclerView_hangmoi_cuahang;
    private RecyclerView.Adapter mAdapter_hangmoi_cuahang;
    private RecyclerView.LayoutManager mLayoutManager_hangmoi_cuahang;
    private ArrayList<visit_1_getter_setter> hangmoi_cuahang;
    // Hàng mới
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view_cuahang = inflater.inflate(R.layout.fragment_cua_hang, container, false);
        initControl();
        initEvent();
        return view_cuahang;
    }

    private void initEvent() {
        cuahang = new ArrayList<>();
        for(int i = 0 ; i < 10 ;i++){
           cuahang.add(new visit_1_getter_setter());

        }
        hangbanchay_cuahang = new ArrayList<>();
        for(int i = 0 ; i < 10 ;i++){
            hangbanchay_cuahang.add(new visit_1_getter_setter());

        }
        hangmoi_cuahang = new ArrayList<>();
        for(int i = 0 ; i < 10 ;i++){
            hangmoi_cuahang.add(new visit_1_getter_setter());

        }
//
        mRecyclerView_cuahang.setHasFixedSize(true);
        mLayoutManager_cuahang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView_cuahang.setLayoutManager(mLayoutManager_cuahang);
        mAdapter_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),cuahang);
        mRecyclerView_cuahang.setAdapter(mAdapter_cuahang);
        // Trưng bày
        mRecyclerView_hangbanchay_cuahang.setHasFixedSize(true);
        mLayoutManager_hangbanchay_cuahang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView_hangbanchay_cuahang.setLayoutManager(mLayoutManager_hangbanchay_cuahang);
        mAdapter_hangbanchay_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),hangbanchay_cuahang);
        mRecyclerView_hangbanchay_cuahang.setAdapter(mAdapter_hangbanchay_cuahang);
        // Hàng bán chạy
        mRecyclerView_hangmoi_cuahang.setHasFixedSize(true);
        mLayoutManager_hangmoi_cuahang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView_hangmoi_cuahang.setLayoutManager(mLayoutManager_hangmoi_cuahang);
        mAdapter_hangmoi_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),hangmoi_cuahang);
        mRecyclerView_hangmoi_cuahang.setAdapter(mAdapter_hangmoi_cuahang);
        //Hàng mới
    }

    private void initControl() {
        mRecyclerView_cuahang = (RecyclerView) view_cuahang.findViewById(R.id.recyclerview_trungbay_cuahang_manage);
        mRecyclerView_hangbanchay_cuahang = (RecyclerView) view_cuahang.findViewById(R.id.recyclerview_hangbanchay_cuahang_manage);
        mRecyclerView_hangmoi_cuahang = (RecyclerView) view_cuahang.findViewById(R.id.recyclerview_hangmoi_cuahang_manage);
    }
}
