package vn.edu.poly.project_one;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_cardview_details;
import vn.edu.poly.project_one.Adapter.Adapter_gridview_nhanxetvadanhgia_details;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;
import vn.edu.poly.project_one.view.ViSit;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class Details extends Fragment {
    private View view_details;
    TextView txt_tensanpham_detail, txt_price_details, txt_remove;
    ImageView img_sp_logo_details;
    Button btn_themvaogio_details;
    private String name = "";
    private String price = "";
    private String url = "";
    private String id = "";
    private int i = 0;
    private int index;
    private RecyclerView mRecyclerView_details;
    private RecyclerView.Adapter mAdapter_details;
    private RecyclerView.LayoutManager mLayoutManager_details;
    private ArrayList<visit_1_getter_setter> arrayList_details;
    private ArrayList<visit_1_getter_setter> arrayList_details_danhgia;
    private GridView gridView;
    private Adapter_gridview_nhanxetvadanhgia_details adapter;
    private SharedPreferences sharedPreferences_index;
    private SharedPreferences.Editor editor_index;
    private RelativeLayout layout_back_details;

    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_details = inflater.inflate(R.layout.fragment_detail, container, false);

        initControl();
        initOnClick();
        initEvent();

        return view_details;
    }

    private void initEvent() {
        arrayList_details_danhgia = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arrayList_details_danhgia.add(new visit_1_getter_setter());
        }
        adapter = new Adapter_gridview_nhanxetvadanhgia_details(arrayList_details_danhgia, getActivity());
        gridView.setAdapter(adapter);
        setGridViewHeightBasedOnChildren(gridView, 1);
        arrayList_details = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList_details.add(new visit_1_getter_setter("" + R.drawable.thoikean));
        }
        mRecyclerView_details.setHasFixedSize(true);
        mLayoutManager_details = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView_details.setLayoutManager(mLayoutManager_details);
        mAdapter_details = new Adapter_cardview_details(getContext(), arrayList_details);
        mRecyclerView_details.setAdapter(mAdapter_details);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details", MODE_PRIVATE);
        name = sharedPreferences.getString("name_sp", null);
        url = sharedPreferences.getString("hinhanh_sp", null);
        price = sharedPreferences.getString("gia_sp", null);
        id = sharedPreferences.getString("id_sp", null);
        if (!(url.isEmpty())) {//null
        } else {
            url = String.valueOf(R.drawable.ic_priority_high_black_24dp);//null
        }
        Picasso.with(getContext())
                .load("http://namtnps06077.hol.es/"+url)
                .resize(67, 67)
                .error(R.drawable.ic_priority_high_black_24dp)//load url error
                .placeholder(R.drawable.ic_priority_high_black_24dp)//load url error
                .into(img_sp_logo_details);
        txt_tensanpham_detail.setText(name);
        txt_price_details.setText(price);
        // Lấy dữ liệu từ Adapter;
//        SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("post_details_index", MODE_PRIVATE);
//        SharedPreferences.Editor editor_index = sharedPreferences_index.edit();
//        editor_index.putInt("index",1 );
//        editor_index.commit();
        sharedPreferences_index = getContext().getSharedPreferences("post_details_index", MODE_PRIVATE);
        editor_index = sharedPreferences_index.edit();
        index = sharedPreferences_index.getInt("index", 0);

        btn_themvaogio_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                index++;
                i++;
                editor_index.putInt("index", index);
                editor_index.commit();
//                if (i > 1) {
//                    int index_more = index - 2;
//                    editor_index.putInt("index_soluong", i);
//                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details_donhang", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("name_sp_" + index_more, name);
//                    editor.putString("gia_sp_" + index_more, price);
//                    editor.putString("id_sp_" + index_more, id);
//                    editor.putString("hinhanh_sp_" + index_more, url);
//                    editor.putInt("soluong_sp_" + index_more, i);
//                    editor.commit();
//                    editor_index.commit();
//                    Log.d("test_soluong", index_more+ "");

//                } else {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details_giohang", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name_sp_" + index, name);
                editor.putString("gia_sp_" + index, price);
                editor.putString("id_sp_" + index, id);
                editor.putString("hinhanh_sp_" + index, url);
                editor.putInt("soluong_sp_" + index, i);
                Log.d("post_details", index + "");
                editor.commit();
//                }

                Toast.makeText(getContext(), "Sản Phẩm: " + name + " Đã Vào Giỏ Hàng ! Số Lượng:" + i, Toast.LENGTH_SHORT).show();
            }

        });
        layout_back_details.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViSit viSit = new ViSit();
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.fragment_detail, viSit);
                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft1.addToBackStack(null);
                ft1.commit();
                return false;
            }
        });

    }


    private void initOnClick() {
    }

    private void initControl() {
        mRecyclerView_details = (RecyclerView) view_details.findViewById(R.id.my_recycler_details);
        txt_tensanpham_detail = (TextView) view_details.findViewById(R.id.txt_tensanpham_detail);
        txt_price_details = (TextView) view_details.findViewById(R.id.txt_price_details);
        btn_themvaogio_details = (Button) view_details.findViewById(R.id.btn_themvaogio_details);
        img_sp_logo_details = (ImageView) view_details.findViewById(R.id.img_sp_logo_details);
        gridView = (GridView) view_details.findViewById(R.id.gridview_danhgia_details);
        layout_back_details = (RelativeLayout) view_details.findViewById(R.id.layout_back_details);

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
