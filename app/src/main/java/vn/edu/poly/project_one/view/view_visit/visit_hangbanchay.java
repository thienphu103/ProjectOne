package vn.edu.poly.project_one.view.view_visit;


import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

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

import vn.edu.poly.project_one.Adapter.MyAdapter_visit_hangbanchay;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter;

import static android.content.Context.MODE_PRIVATE;
import static vn.edu.poly.project_one.SETUP_API.CallApiMySQL.URL_LOCAL_HOST;

/**
 * Created by ASUS on 11/20/2017.
 */

public class visit_hangbanchay extends Fragment {
    View view_visit_hangbanchay;
    GridView gridView;
    MyAdapter_visit_hangbanchay adapter;
    ArrayList<visit_hangbanchay_getter_setter> arrayList;
    ImageView img_kieudanhsach;
    ImageView img_gridview_visit_hangbanchay_tablayoutactivity;
    public static final String URL_CALL_API_GET_DATA = "http://"+URL_LOCAL_HOST+"//serverlocal/get_data_sanpham.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit_hangbanchay = inflater.inflate(R.layout.fragment_thamquan_hangbanchay, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_visit_hangbanchay;
    }

    private void initOnClick() {
        img_kieudanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangbanchay_kieulietke visit_view = new visit_hangbanchay_kieulietke();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangbanchay, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

    private void initControl() {
        img_kieudanhsach = (ImageView) view_visit_hangbanchay.findViewById(R.id.img_kieudanhsachlietke_visit_hangbanchay_tablayoutactivity);
        gridView = (GridView) view_visit_hangbanchay.findViewById(R.id.gridview_visit__hangbanchay_tablayoutactivity);
        getData();
//        arrayList = new ArrayList<>();
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        adapter = new MyAdapter_visit_hangbanchay(getContext(),arrayList);
//        gridView.setAdapter(adapter);

    }

    private void initEvent() {


//        FragmentManager fm = getFragmentManager();
//        visit_hangbanchay visit_hangbanchay  = (visit_hangbanchay) fm.findFragmentById(R.id.fragment_visit_hangbanchay);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.hide( visit_hangbanchay);
//        ft.commit();
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URL_CALL_API_GET_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String name = "";
                String image;
                String price;
                arrayList = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        name = object.getString("ten_sp");
                        image = object.getString("hinhanh_sp");
                        price =object.getString("gia_sp");
                        Log.d("URl_IMAGE", image);
                        arrayList.add(new visit_hangbanchay_getter_setter(
                           image,name,price));
                        adapter = new MyAdapter_visit_hangbanchay(getContext(),arrayList);
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    gridView.setAdapter(adapter);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();
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

}
