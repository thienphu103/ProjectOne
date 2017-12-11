package vn.edu.poly.project_one.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_sanpham_giohang;
import vn.edu.poly.project_one.ControlClass.CircleTransform;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.SanPham;
import vn.edu.poly.project_one.view.view_giohang.giohang_1_diachigiaohang;

import static android.content.Context.MODE_PRIVATE;

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
    Context myContext, appContext;
    private Bundle arguments;
    private String name;
    private String price;
    private String url;
    private SharedPreferences sharedPreferences_data;
    private SharedPreferences.Editor editor_index;
    private TextView txt_remove;
    private int dongia_post;
    private int soluong;
    private int soluong_post;
    private String id;
    private String id_post;
    private String dongia_post_txt;
    private String name_post_txt;
    private FragmentManager fragmentManager;
    private int index_back_fragment;
    private FragmentManager fm;
    private ImageView imageView_avatar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_giohang = inflater.inflate(R.layout.fragment_giohang, container, false);
        initEvent();
        initControl();
        initOnClick();
        init_check_fragment();
        return view_giohang;
    }

    private void initOnClick() {

        btn_dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("post_details_bull", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences_index.edit();
                editor.putInt("dongia", dongia_post);
                editor.putString("id_sp_txt", id_post);
                editor.putInt("soluong_sp", soluong_post);
                editor.putString("dongia_txt",dongia_post_txt);
                editor.putString("name_txt",name_post_txt);
                editor.commit();
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
        txt_sum = (TextView) view_giohang.findViewById(R.id.txt_dathang_giohang);
        txt_remove = (TextView) view_giohang.findViewById(R.id.txt_remove);
        imageView_avatar=(ImageView) view_giohang.findViewById(R.id.image_avatar_giohang) ;
        id_post = "";
        dongia_post = 0;
        dongia_post_txt="";
        name_post_txt="";

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("name_login", getContext().MODE_PRIVATE);
        String user = sharedPreferences.getString("username", null);
        String url = sharedPreferences.getString("url", null);
        if (user != null) {
            Log.d("ContentLogin", user + " " + url + "");
            if (url == null) {
                url = String.valueOf(R.drawable.img_no_avatar);//null
            } else {
                Picasso.with(getContext())
                        .load(url)

                        .transform(new CircleTransform())
                        .error(R.drawable.img_no_avatar)//load url error
                        .placeholder(R.drawable.img_no_avatar)//load url error
                        .into(imageView_avatar);
            }
        }

    }

    private void initControl() {
        sanPhamArrayList = new ArrayList<>();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details_index", context.MODE_PRIVATE);
        int index = sharedPreferences.getInt("index", 0);
        int index_soluong = sharedPreferences.getInt("index_soluong", 0);

        editor_index = sharedPreferences.edit();
//        editor_index.clear().commit();
        for (int i = 1; i < index + 1; i++) {
            i++;
            sharedPreferences_data = getContext().getSharedPreferences("post_details_giohang", context.MODE_PRIVATE);
            name = sharedPreferences_data.getString("name_sp_" + i, null);
            price = sharedPreferences_data.getString("gia_sp_" + i, null);
            url = sharedPreferences_data.getString("hinhanh_sp_" + i, null);
            id = sharedPreferences_data.getString("id_sp_" + i, null);
            soluong = sharedPreferences_data.getInt("soluong_sp_" + i, 0);
            sanPhamArrayList.add(new SanPham(name,
                    price, soluong + "", "3",
                    url));
            id_post += id + ",";
            dongia_post += Double.parseDouble(price);
            dongia_post_txt+=price+",";
            name_post_txt+=name+",";
            soluong_post += soluong;
            Log.d("index", index + "_" + i + "_" + id_post);
        }
        if(sanPhamArrayList.size()==0){
            btn_dathang.setEnabled(false);
            btn_dathang.setAlpha((float) 0.3);
        }else {
            btn_dathang.setEnabled(true);
            btn_dathang.setAlpha((float) 1);
        }
        txt_sum.setText("Có " + sanPhamArrayList.size() + " Sản Phẩm, Tạm Tính:" + dongia_post +" ");
        mRecyclerView_giohang.setHasFixedSize(true);
        mLayoutManager_giohang = new LinearLayoutManager(getActivity());
        mRecyclerView_giohang.setLayoutManager(mLayoutManager_giohang);
        adapter = new Adapter_sanpham_giohang(getContext(), sanPhamArrayList);
        mRecyclerView_giohang.setAdapter(adapter);
        txt_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("post_details_index", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences_index.edit();
                editor.putInt("index", 0);
                editor.commit();
                editor_index.clear().commit();
                dongia_post = 0;
                id_post = "";
                initControl();
            }
        });

    }
    public void init_check_fragment() {
        view_giohang.setFocusableInTouchMode(true);
        view_giohang.requestFocus();
        fm = getActivity().getSupportFragmentManager();
        index_back_fragment = fm.getBackStackEntryCount() + 2;
        view_giohang.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    index_back_fragment--;
                    if(index_back_fragment==0){
                        Toast.makeText(getContext(),"Nhấn Lần Nữa Để Về Home",Toast.LENGTH_LONG).show();
                    }
                    try {
                        if (index_back_fragment > 0) {
                            getActivity().getSupportFragmentManager().popBackStackImmediate();
                        }
                        if (index_back_fragment < 0) {
                            TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
                            tabhost.getTabAt(0).select();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    return true;
                }
                return false;
            }
        });
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
