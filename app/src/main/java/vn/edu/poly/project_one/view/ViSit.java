package vn.edu.poly.project_one.view;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.ImageAdapter_visit;
import vn.edu.poly.project_one.Adapter.MyAdapter_visit;
import vn.edu.poly.project_one.Adapter.MyAdapter_visit_2;
import vn.edu.poly.project_one.Details;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;
import vn.edu.poly.project_one.View_getter_setter.visit_2_getter_setter;
import vn.edu.poly.project_one.view.view_visit.visit_danhsachcuahang;
import vn.edu.poly.project_one.view.view_visit.visit_hangbanchay;
import vn.edu.poly.project_one.view.view_visit.visit_hangmoi_kieudanhsach;

/**
 * Created by ASUS on 11/18/2017.
 */

public class ViSit extends Fragment {
    private View.OnClickListener click;
    View view_visit;
    TextView txt_hangbanchay_tablayoutactivity,txt_hangmoi_tablayoutactivty;
    TextView txt_danhsachcuahang_tablayoutactivity;
    GridView gridview_visit;
    private RecyclerView mRecyclerView_visit;
    private RecyclerView.Adapter mAdapter_visit;
    private RecyclerView.LayoutManager mLayoutManager_visit;
    private ArrayList<visit_1_getter_setter> strings;
    MyAdapter_visit adapter;
    private ArrayList<visit_2_getter_setter> strings2;
    MyAdapter_visit_2 adapter2;
    private RecyclerView mRecyclerView_visit_2;
    private RecyclerView.Adapter mAdapter_visit_2;
    private RecyclerView.LayoutManager mLayoutManager_visit_2;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    public static final String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/get_data_sp_banchay.php";
    public static final String URL_CALL_API_GET_DATA_2 = "http://namtnps06077.hol.es/get_data_sp_moi_nhat.php";
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit = inflater.inflate(R.layout.fragment_thamquan, container, false);

        initControl();
        initOnClick();
        initEvent();
        return view_visit;
    }

    private void initOnClick() {
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Details details = new Details();
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.fragmelayout_visit,details);
                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft1.addToBackStack(null);
                ft1.commit();
            }
        };
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
//        mRecyclerView_visit.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//                Toast.makeText(getActivity(),"b",Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });

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
        strings2 = new ArrayList<>();
        getData();
        getData2();


//        strings = new ArrayList<>();
//        for(int i = 0 ; i < 10 ;i++){
//            strings.add(new visit_1_getter_setter(getResources().getString(R.string.txt_amthuc_tablayoutactivity)
//            ,getResources().getString(R.string.txt_gia_tablayoutactivity))
//            );
//        }
//        strings_2 = new ArrayList<>();
//        for(int i = 0 ; i < 10 ;i++){
//            strings_2.add(getResources().getString(R.string.txt_tenhang_tablayoutactivity));
//        }
        mRecyclerView_visit.setHasFixedSize(true);
        mLayoutManager_visit = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_visit.setLayoutManager(mLayoutManager_visit);
//        mAdapter_visit = new MyAdapter_visit(getContext(),strings);
//        mRecyclerView_visit.setAdapter(mAdapter_visit);
        mRecyclerView_visit_2.setHasFixedSize(true);
        mLayoutManager_visit_2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_visit_2.setLayoutManager(mLayoutManager_visit_2);
//        mAdapter_visit_2 = new MyAdapter_visit_2(getContext(),strings2);
//        mRecyclerView_visit_2.setAdapter(mAdapter_visit_2);
        gridview_visit.setAdapter(new ImageAdapter_visit(getActivity()));
        setGridViewHeightBasedOnChildren(gridview_visit,2);
        collapsingToolbarLayout = (CollapsingToolbarLayout) view_visit.findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.txt_visit_tablayoutactivity));
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.black));

    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URL_CALL_API_GET_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String name = "";
                String image;
                String price;
                String id;
String number;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        name = object.getString("ten_sp");
                        image = object.getString("hinhanh_sp");
                        price = object.getString("gia_sp");
                        number=object.getString("soluongconlai_sp");
                        id=object.getString("id_sp");

                        Log.d("URl_IMAGE", image);
                        strings.add(new visit_1_getter_setter(Integer.parseInt(id),name,price,image,number));
//                        adapter =new MyAdapter_visit(getContext(),strings);
//                        adapter.notifyDataSetChanged();

//                        adapter2 =new MyAdapter_visit_2(getContext(),strings2);
//                        adapter2.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mAdapter_visit = new MyAdapter_visit(getContext(),strings,click);
                    mAdapter_visit.notifyDataSetChanged();

                    mRecyclerView_visit.setAdapter(mAdapter_visit);

Log.d("a","aa");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();
                View view = view_visit.findViewById(R.id.fragmelayout_visit);
                final Snackbar snackbar = Snackbar.make(view,"Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);

                // Set an action on it, and a handler
                snackbar.setAction("Thử Lại", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getData();
                        getData2();
                    }
                });

                snackbar.show();
            }
        });

        requestQueue.add(arrayRequest);
    }
    private void getData2() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URL_CALL_API_GET_DATA_2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String name = "";
                String image;
                String price;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        name = object.getString("ten_sp");
                        image = object.getString("hinhanh_sp");
                        price = object.getString("gia_sp");
                        Log.d("URl_IMAGE", image);

//                        adapter =new MyAdapter_visit(getContext(),strings);
//                        adapter.notifyDataSetChanged();
                        strings2.add(new visit_2_getter_setter(name,price,image));
//                        adapter2 =new MyAdapter_visit_2(getContext(),strings2);
//                        adapter2.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    mAdapter_visit_2 = new MyAdapter_visit_2(getContext(),strings2,click);
                    mAdapter_visit_2.notifyDataSetChanged();
                    mRecyclerView_visit_2.setAdapter(mAdapter_visit_2);
                    Log.d("a","aa");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();
                View view = view_visit.findViewById(R.id.fragmelayout_visit);
                final Snackbar snackbar = Snackbar.make(view,"Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);

                // Set an action on it, and a handler
                snackbar.setAction("Thử Lại", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getData();
                    }
                });

                snackbar.show();
            }
        });

        requestQueue.add(arrayRequest);
    }
    public String decodeImage(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteImage = outputStream.toByteArray();
        String encodeImage = Base64.encodeToString(byteImage, Base64.DEFAULT);
        return encodeImage;
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
